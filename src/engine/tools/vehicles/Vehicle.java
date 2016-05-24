package engine.tools.vehicles;

import engine.people.AbstractPerson;
import engine.people.PersonContainer;
import engine.planets.Grid;
import engine.planets.LocationPlanet;
import engine.planets.Planet;
import engine.tools.Tool;
import engine.tools.weapons.Weapon;
import engine.tools.weapons.WeaponContainer;
import engine.universe.MoneySource;
import engine.universe.MoneySourceContainer;
import engine.universe.Resource;
import javafx.scene.image.Image;

import java.util.ArrayList;

public abstract class Vehicle extends Tool implements Liver,PersonContainer, VehicleContainer, WeaponContainer,
		MoneySourceContainer
{
	private double fuelPercent = 0.0;//from 0 t  1
	private double fuelCapacity = 0.0;//from 0 to 1
	private ArrayList<AbstractPerson> passengers;
	private ArrayList<Resource> cargo;
	private ArrayList<Weapon> weapons;
	private ArrayList<Vehicle> vehicles;
	private int maxPassengers;
	private double maxWeight;
	protected Vehicle(VehicleInitialConstants vehicleInitialConstants, int numToolsConstructor) {
		super(vehicleInitialConstants.attackableConstants, numToolsConstructor);
		registerPersonContainer();
		registerMoneySourceContainer();
		registerVehicleContainer();
		registerWeaponContainer();
		registerLiver();// TODO: 5/22/2016 go through and check these
		maxPassengers = vehicleInitialConstants.maxPassengers;
		maxWeight = vehicleInitialConstants.maxWeight;
		passengers = new ArrayList<>();
		cargo = new ArrayList<>();
		weapons = new ArrayList<>();
		vehicles = new ArrayList<>();
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
			}
			else if(weighable instanceof Weapon) {
				weapons.add((Weapon) weighable);
			}
			else if(weighable instanceof Resource) {
				cargo.add((Resource) weighable);
			}
			else if(weighable instanceof AbstractPerson) {
				if(passengers.size() < maxPassengers)
					passengers.add((AbstractPerson) weighable);
			}
			else
				throw new IllegalStateException();
		}
		else
			throw new Weighable.ToHeavyException(weighable);
	}
	// TODO: 5/22/2016 unloading objects
	public  boolean canAddObject(Weighable weighable)
	{
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
	public void die()
	{
		VehicleContainer.killVehicle(this);
	}
	@Override
	public void remove(AbstractPerson person) {
		passengers.remove(person);
	}
	@Override
	public void remove(Vehicle vehicle) {
		vehicles.remove(vehicle);
	}
	@Override
	public void remove(Weapon weapon) {
		weapons.remove(weapon);
	}
	@Override
	public void remove(MoneySource in) {
		for (AbstractPerson passenger : passengers) {
			if(passenger.moneySource == in)
				passenger.moneySource = null;
		}
	}

	public void setDestination(LocationPlanet locationPlanet) {
		destination = locationPlanet;
	}
	private LocationPlanet destination = null;
	@Override
	public void doLife(long time) {
		if(destination != null) {
			assert (getLocation().size() == 1);
			Grid initialGrid = getLocation().get(0).getGrid();
			getLocation().get(0).goTowards(destination, (getSpeed() * time) / (12 * 60 * 60), false);
			Grid finalGrid = getLocation().get(0).getGrid();
			if(finalGrid != initialGrid) {
				initialGrid.vehicleLeaves(this);
				finalGrid.vehicleArrives(this);
			}
			for (AbstractPerson passenger : passengers) {
				// TODO: 5/22/2016 update passenger locations
			}
			for (Resource resource : cargo) {
				// TODO: 5/22/2016 update locationn
			}
			for (Weapon weapon : weapons) {
				// TODO: 5/22/2016 update llocations
			}
			for (Vehicle vehicle : vehicles) {
				// TODO: 5/22/2016 update locations
			}
		}
	}
}