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

import java.util.ArrayList;

public abstract class Vehicle extends Tool implements Attackable, PersonContainer, VehicleContainer, WeaponContainer, MoneySourceContainer
{
	private double fuelPercent = 0.0;//from 0 t  1
	private double fuelCapacity = 0.0;//from 0 to 1
	private ArrayList<AbstractPerson> passengers;
	private ArrayList<Resource> cargo;
	private ArrayList<MoneySource> money;//could just use a bureucrat as passenger
	private ArrayList<Weapon> weapons;
	private ArrayList<Vehicle> vehicles;
	public Vehicle()
	{

	}

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