



















package tools.vehicles;

import people.AbstractPerson;
import tools.Tool;
import tools.weapons.Attackable;
import tools.weapons.Weapon;
import universe.MoneySource;
import universe.Resource;

import java.util.ArrayList;

public abstract class Vehicle extends Tool implements Attackable
{
	private double fuelPercent = 0.0;//from 0 t  1
	private double fuelCapacity = 0.0;//from 0 to 1
	private ArrayList<AbstractPerson> passengers;
	private ArrayList<Resource> cargo;
	private ArrayList<MoneySource> money;//could just use a bureucrat as passenger
	private ArrayList<Weapon> weapons;
	private ArrayList<Vehicle> vehicles;
	public Vehicle(Type type)
	{
		super(type);
	}

	//	public abstract boolean spaceQ();
//	public abstract boolean seaQ();
//	public abstract boolean landQ();
//	public abstract boolean roadgoingQ();
	public abstract boolean inSpaceQ();
	public abstract boolean inWaterQ();
	//deprecate roadgoing
	public boolean weaponQ() {
		return false;
	}

	public boolean vehicleQ()
	{
		return true;
	}
	
	
}