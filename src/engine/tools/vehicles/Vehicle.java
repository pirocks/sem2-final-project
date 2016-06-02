package engine.tools.vehicles;

import engine.cities.Container;
import engine.people.AbstractPerson;
import engine.planets.Grid;
import engine.planets.LocationPlanet;
import engine.planets.Planet;
import engine.planets.TerrainType;
import engine.tools.Tool;
import engine.tools.vehicles.air.Aircraft;
import engine.tools.vehicles.sea.SeaCraft;
import engine.tools.vehicles.space.SpaceCraft;
import engine.tools.weapons.Attackable;
import engine.tools.weapons.Weapon;
import engine.universe.MoneySource;
import engine.universe.Resource;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public abstract class Vehicle extends Tool implements Liver,Container
{
	private Set<AbstractPerson> passengers;
	private Set<Resource> cargo;
	private Set<Weapon> weapons;
	private Set<Vehicle> vehicles;
	private int maxPassengers;
	private double maxWeight;
	protected Vehicle(VehicleInitialConstants vehicleInitialConstants, int numToolsConstructor) {
		super(vehicleInitialConstants.attackableConstants, numToolsConstructor);
		registerLiver();
		maxPassengers = vehicleInitialConstants.maxPassengers;
		maxWeight = vehicleInitialConstants.maxWeight;
		passengers = new HashSet<>();
		cargo = new HashSet<>();
		weapons = new HashSet<>();
		vehicles = new HashSet<>();
		registerContainer(passengers);
		registerContainer(weapons);
		registerContainer(vehicles);
		for (LocationPlanet locationPlanet : vehicleInitialConstants.attackableConstants.locationPlanet) {
			Planet p = locationPlanet.getPlanet();
			if(p != null) {
				Grid grid = p.getGrids()[locationPlanet.getGridy()][locationPlanet.getGridx()];
				grid.vehicleArrives(this);
			}//hacky
			// TODO: 5/30/2016 fix this
		}
	}
	public abstract boolean inSpaceQ();
	public abstract boolean inWaterQ();
	public abstract double getSpeed();
	public boolean weaponQ() {
		return false;
	}
	public boolean vehicleQ()
	{
		return true;
	}
	public void loadObject(Weighable weighable) throws ToHeavyException {
		if(canAddObject(weighable)) {
			if (weighable instanceof Vehicle) {
				vehicles.add((Vehicle) weighable);
				registerContainer((Attackable) weighable);
			}
			else if(weighable instanceof Weapon) {
				weapons.add((Weapon) weighable);
				registerContainer((Attackable) weighable);

			}
			else if(weighable instanceof Resource) {
				cargo.add((Resource) weighable);
			}
			else if(weighable instanceof AbstractPerson) {
				if(passengers.size() < maxPassengers) {
					passengers.add((AbstractPerson) weighable);
					registerContainer((Attackable) weighable);
				}
			}
			else
				throw new IllegalStateException();
		}
		else
			throw new Weighable.ToHeavyException(weighable);
	}
	public Vehicle unloadVehicle(Vehicle vehicle){
		if(vehicles.contains(vehicle))
		{
			vehicles.remove(vehicle);
			deregisterContainer(vehicle);
		}
		else
		{
			throw  new IllegalStateException();
		}
		return vehicle;
	}
	public Resource unloadResource(Resource resource){
		if(cargo.contains(resource))
		{
			cargo.remove(resource);
		}
		else
		{
			throw  new IllegalStateException();
		}
		return resource;
	}
	public AbstractPerson unloadPerson(AbstractPerson abstractPerson){
		if(passengers.contains(abstractPerson))
		{
			passengers.remove(abstractPerson);
			deregisterContainer(abstractPerson);
		}
		else
		{
			throw  new IllegalStateException();
		}
		return abstractPerson;
	}
	public Weapon unloadWeapon(Weapon weapon){
		if(weapons.contains(weapon))
		{
			weapons.remove(weapon);
			deregisterContainer(weapon);
		}
		else
		{
			throw  new IllegalStateException();
		}
		return weapon;
	}
	public  boolean canAddObject(Weighable weighable) {
		return canAddWeight(weighable.getWeight());
	}
	private boolean canAddWeight(double weight) {
		return getTotalWeightLoad() + weight < maxWeight;
	}
	private double getTotalWeightLoad() {
		double out = 0;
		for(AbstractPerson abstractPerson:passengers)
			out += abstractPerson.getWeight();
		for(Resource resource: cargo)
			out += resource.getWeight();
		for(Weapon weapon: weapons)
			out += weapon.getWeight();
		for(Vehicle vehicle: vehicles)
			out += vehicle.getWeight();
		return out;
	}
	public void die() {
		Container.kill(new ArrayList<Attackable>(passengers));
		Container.kill(new ArrayList<Attackable>(weapons));
		Container.kill(new ArrayList<Attackable>(vehicles));
	}
	private void remove(AbstractPerson person) {
		passengers.remove(person);
	}
	private void remove(Vehicle vehicle) {
		vehicles.remove(vehicle);
	}
	private void remove(Weapon weapon) {
		weapons.remove(weapon);
	}
	private void remove(MoneySource in) {
		for (AbstractPerson passenger : passengers) {
			if(passenger.moneySource == in)
				passenger.moneySource = null;
		}
	}
	public void setDestination(LocationPlanet destination) {
		path = new ArrayList<>();
//		path = determinePathWrapper(this.getLocation().get(0),destination,this instanceof SeaCraft || this instanceof Aircraft || this instanceof SpaceCraft,!(this instanceof SeaCraft));
	}

//	private ArrayList<LocationPlanet> determinePathWrapper(LocationPlanet start, LocationPlanet destination, boolean  waterOkQ, boolean landOkQ) {
//		ArrayList<LocationPlanet> pathList = determinePath(new LocationPlanet(start),destination,waterOkQ,landOkQ);
//	}
//	private ArrayList<ArrayList<LocationPlanet>> createPaths(LocationPlanet start, LocationPlanet destination, boolean  waterOkQ, boolean landOkQ) {
//		ArrayList<ArrayList<LocationPlanet>> possiblePaths = new ArrayList<>();
//		if(validQ(new LocationPlanet(start){{moveGrid(start.getGridx() + 1,start.getGridy());}},waterOkQ,landOkQ))
//			possiblePaths.addAll(determinePath(new LocationPlanet(start){{moveGrid(start.getGridx(),start.getGridy());}},destination,waterOkQ,landOkQ));
//		if(validQ(new LocationPlanet(start){{moveGrid(start.getGridx() + 1,start.getGridy() + 1);}},waterOkQ,landOkQ))
//			possiblePaths.addAll(determinePath(new LocationPlanet(start){{moveGrid(start.getGridx(),start.getGridy());}},destination,waterOkQ,landOkQ));
//		if(validQ(new LocationPlanet(start){{moveGrid(start.getGridx() + 1,start.getGridy() - 1);}},waterOkQ,landOkQ))
//			possiblePaths.addAll(determinePath(new LocationPlanet(start){{moveGrid(start.getGridx(),start.getGridy());}},destination,waterOkQ,landOkQ));
//		if(validQ(new LocationPlanet(start){{moveGrid(start.getGridx() - 1,start.getGridy());}},waterOkQ,landOkQ))
//			possiblePaths.addAll(determinePath(new LocationPlanet(start){{moveGrid(start.getGridx(),start.getGridy());}},destination,waterOkQ,landOkQ));
//		if(validQ(new LocationPlanet(start){{moveGrid(start.getGridx() - 1,start.getGridy() + 1);}},waterOkQ,landOkQ))
//			possiblePaths.addAll(determinePath(new LocationPlanet(start){{moveGrid(start.getGridx(),start.getGridy());}},destination,waterOkQ,landOkQ));
//		if(validQ(new LocationPlanet(start){{moveGrid(start.getGridx() - 1,start.getGridy() - 1);}},waterOkQ,landOkQ))
//			possiblePaths.addAll(determinePath(new LocationPlanet(start){{moveGrid(start.getGridx(),start.getGridy());}},destination,waterOkQ,landOkQ));
//		if(validQ(new LocationPlanet(start){{moveGrid(start.getGridx(),start.getGridy());}},waterOkQ,landOkQ))
//			possiblePaths.addAll(determinePath(new LocationPlanet(start){{moveGrid(start.getGridx(),start.getGridy());}},destination,waterOkQ,landOkQ));
//		if(validQ(new LocationPlanet(start){{moveGrid(start.getGridx(),start.getGridy() + 1);}},waterOkQ,landOkQ))
//			possiblePaths.addAll(determinePath(new LocationPlanet(start){{moveGrid(start.getGridx(),start.getGridy());}},destination,waterOkQ,landOkQ));
//		if(validQ(new LocationPlanet(start){{moveGrid(start.getGridx(),start.getGridy() - 1);}},waterOkQ,landOkQ))
//			possiblePaths.addAll(determinePath(new LocationPlanet(start){{moveGrid(start.getGridx(),start.getGridy());}},destination,waterOkQ,landOkQ));
//
//		for (ArrayList<LocationPlanet> possiblePath : possiblePaths) {
//
//		}
//
//
//	}

	public class Path{
		ArrayList<LocationPlanet> locationPlanets;

		public Path(ArrayList<LocationPlanet> locationPlanets) {
			this.locationPlanets = locationPlanets;
		}
		public Path(Path path,LocationPlanet locationPlanet){
			// TODO: 6/1/2016
		}

		public double getLength(){
			double out = 0;
			LocationPlanet prev = locationPlanets.get(0);
			for (LocationPlanet locationPlanet : locationPlanets) {
				out += locationPlanet.distanceBetween(prev);
				prev = locationPlanet;
			}
			return out;
		}
		public ArrayList<Path> getPathsGoingFrom(boolean waterOkQ,boolean landOkQ){
			LocationPlanet start = locationPlanets.get(locationPlanets.size() - 1);
			ArrayList<Path> possiblePaths = new ArrayList<>();
			if(validQ(this,new LocationPlanet(start){{moveGrid(start.getGridx(),start.getGridy());}},waterOkQ,landOkQ))
				possiblePaths.add(new Path(this,new LocationPlanet(start){{moveGrid(start.getGridx(),start.getGridy());}}));
			return possiblePaths;
		}
		private boolean validQ(Path previous,LocationPlanet locationPlanet, boolean waterOkQ,boolean landOkQ) {
			if(locationPlanet.getGrid().getTerrainType() == TerrainType.Sea){
				if(waterOkQ){
					return true;
				}
			}else{// TODO: 6/1/2016
				if(landOkQ){
					return true;
				}
			}
			return false;
		}
	}


	public LocationPlanet getDestination() {
		try{
			return path.get(path.size() - 1);
		}catch (IndexOutOfBoundsException e){
			return null;
		}
	}
	@Override
	public boolean sanityCheck() {
		if(passengers == null)
			throw new IllegalStateException();
		if(cargo == null)
			throw new IllegalStateException();
		if(weapons == null)
			throw new IllegalStateException();
		if(maxPassengers < 0)
			throw new IllegalStateException();
		double weight = 0;
		for (AbstractPerson passenger : passengers) {
			weight += passenger.getWeight();
		}
		for (Resource resource : cargo) {
			weight += resource.getWeight();
		}
		for (Weapon weapon : weapons) {
			weight += weapon.getWeight();
		}
		if(weight > getWeight())
			throw new IllegalStateException();
		if(numTools  <= 0){
			Liver.deregister(this);
		}
		return true;
	}
	private ArrayList<LocationPlanet> path = new ArrayList<>();
	@Override
	public void doLife(double time) {
		if(path != null & path.size() != 0) {
			assert (getLocation().size() == 1);
			Grid initialGrid = getLocation().get(0).getGrid();
			try {

				for (LocationPlanet locationPlanet : getLocation()) {
						locationPlanet.goTowards(path.get(0), (getSpeed() * time) / (12 * 60 * 60), false,this instanceof SeaCraft || this instanceof Aircraft || this instanceof SpaceCraft,this instanceof SpaceCraft);
				}
			} catch (LocationPlanet.InTheOceanException e) {
				throw new IllegalStateException();
			}

			Grid finalGrid = getLocation().get(0).getGrid();
			if(finalGrid != initialGrid) {
				initialGrid.vehicleLeaves(this);
				finalGrid.vehicleArrives(this);
			}
			for (AbstractPerson passenger : passengers) {
				passenger.setLocation(this.location);
			}
			for (Resource resource : cargo) {
				// TODO: 5/25/2016 location?
			}
			for (Weapon weapon : weapons) {
				weapon.setLocation(this.location);
			}
			for (Vehicle vehicle : vehicles) {
				vehicle.setLocation(this.location);
			}
		}
	}
	@Override
	public void remove(Attackable attackable) {
		if(attackable instanceof Weapon) {
			remove((Weapon) attackable);
		}
		else if(attackable instanceof Vehicle) {
			remove((Vehicle)attackable);
		}
		else if(attackable instanceof AbstractPerson){
			remove((AbstractPerson)attackable);
		}

	}
	public Set<AbstractPerson> getPassengers() {
		return passengers;
	}
	public Set<Resource> getCargo() {
		return cargo;
	}
	public Set<Vehicle> getVehicles() {
		return vehicles;
	}
	public Set<Weapon> getWeapons() {
		return weapons;
	}
	//color adjust is what I should se with javafx
}