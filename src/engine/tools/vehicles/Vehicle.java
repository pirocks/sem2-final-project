package engine.tools.vehicles;

import engine.cities.Container;
import engine.people.AbstractPerson;
import engine.planets.Grid;
import engine.planets.LocationPlanet;
import engine.planets.Planet;
import engine.tools.Tool;
import engine.tools.vehicles.air.Aircraft;
import engine.tools.vehicles.sea.SeaCraft;
import engine.tools.vehicles.space.SpaceCraft;
import engine.tools.weapons.Attackable;
import engine.tools.weapons.Weapon;
import engine.universe.MoneySource;
import engine.universe.Resource;
import javafx.scene.image.Image;
import ui.requests.Request;
import ui.requests.VehicleInWaterRequest;

import java.util.ArrayList;

public abstract class Vehicle extends Tool implements Liver,Container
{
	private ArrayList<AbstractPerson> passengers;
	private ArrayList<Resource> cargo;
	private ArrayList<Weapon> weapons;
	private ArrayList<Vehicle> vehicles;
	private int maxPassengers;
	private double maxWeight;
	protected Vehicle(VehicleInitialConstants vehicleInitialConstants, int numToolsConstructor) {
		super(vehicleInitialConstants.attackableConstants, numToolsConstructor);
		registerLiver();// TODO: 5/22/2016 go through and check these
		maxPassengers = vehicleInitialConstants.maxPassengers;
		maxWeight = vehicleInitialConstants.maxWeight;
		passengers = new ArrayList<>();
		cargo = new ArrayList<>();
		weapons = new ArrayList<>();
		vehicles = new ArrayList<>();
		registerContainer(passengers);
		registerContainer(weapons);
		registerContainer(vehicles);
		for (LocationPlanet locationPlanet : vehicleInitialConstants.attackableConstants.locationPlanet) {
			Planet p = locationPlanet.getPlanet();
			Grid grid = p.getGrids()[locationPlanet.getGridy()][locationPlanet.getGridx()];
			grid.vehicleArrives(this);
		}
	}
	public abstract boolean inSpaceQ();
	public abstract boolean inWaterQ();
	public abstract double getSpeed();
	public abstract Image getImage();
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
		Container.kill(passengers);
		Container.kill(weapons);
		Container.kill(vehicles);
	}
	public void remove(AbstractPerson person) {
		passengers.remove(person);
	}
	public void remove(Vehicle vehicle) {
		vehicles.remove(vehicle);
	}
	public void remove(Weapon weapon) {
		weapons.remove(weapon);
	}
	public void remove(MoneySource in) {
		for (AbstractPerson passenger : passengers) {
			if(passenger.moneySource == in)
				passenger.moneySource = null;
		}
	}
	public void setDestination(LocationPlanet locationPlanet) {
		destination = locationPlanet;
	}
	public LocationPlanet getDestination() {
		return destination;
	}
	private LocationPlanet destination = null;
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
		if(numTools  <= 0)
			throw new IllegalStateException();
		return true;
	}
	@Override
	public void doLife(long time) {
		System.out.println("called");
		if(destination != null) {
			assert (getLocation().size() == 1);
			Grid initialGrid = getLocation().get(0).getGrid();
			try {
				for (LocationPlanet locationPlanet : getLocation()) {
						locationPlanet.goTowards(destination, (getSpeed() * time) / (12 * 60 * 60), false,this instanceof SeaCraft || this instanceof Aircraft || this instanceof SpaceCraft,this instanceof SpaceCraft);
				}
			} catch (LocationPlanet.InTheOceanException e) {
				Request request = new VehicleInWaterRequest(this);
				request.askUser();
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
}