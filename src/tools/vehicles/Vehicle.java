package tools.vehicles;

import people.AbstractPerson;
import people.PersonContainer;
import tools.Tool;
import tools.weapons.Attackable;
import tools.weapons.Weapon;
import tools.weapons.WeaponContainer;
import universe.MoneySource;
import universe.MoneySourceContainer;
import universe.Resource;
import universe.ResourceDemand;

import java.util.ArrayList;

public abstract class Vehicle extends Tool implements Attackable, PersonContainer, VehicleContainer, WeaponContainer, MoneySourceContainer
{
	private double fuelPercent = 0.0;//from 0 t  1
	private double fuelCapacity = 0.0;//from 0 to 1
	private ArrayList<AbstractPerson> passengers;
	private ArrayList<Resource> cargo;
	private ArrayList<Weapon> weapons;
	private ArrayList<Vehicle> vehicles;
	private int maxPassengers;
	private double maxWeight;
	protected Vehicle(double resistance, double startHealth,int maxPassengers, double maxWeight) {
		super(resistance, startHealth);
		this.maxPassengers = maxPassengers;
		this.maxWeight = maxWeight;
		passengers = new ArrayList<>();
		cargo = new ArrayList<>();
		weapons = new ArrayList<>();
		vehicles = new ArrayList<>();
	}
	public abstract boolean inSpaceQ();
	public abstract boolean inWaterQ();
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
				passengers.add((AbstractPerson) weighable);
			}
			else
				throw new IllegalStateException();
		}
		else
			throw new Weighable.ToHeavyException(weighable);
	}
	public  boolean canAddObject(Weighable weighable)
	{
		return canAddWeight(weighable.getWeight());
	}
	private boolean canAddWeight(double weight) {
		if(getTotalWeightLoad() + weight < maxWeight)
			return true;
		return  false;
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
		//TODO unimplemented
	}
}