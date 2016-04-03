



















package tools.vehicles;
import universe.*;
import java.util.ArrayList;
import cities.AbstractPerson;
import tools.*;

public class Vehicle extends Tool
{
	// public Location location;
	private ArrayList<AbstractPerson> passengers;
	private ArrayList<Resource> cargo;
	private ArrayList<MoneySource> money;//could just use a bureucrat as passenger
	private ArrayList<Weapon> weapons;
	private ArrayList<Vehicle> vehicles;
	public Vehicle()
	{
		
	}
	public abstract boolean spaceQ();
	public abstract boolean seaQ();
	public abstract boolean landQ();
	public abstract boolean roadgoingQ();
	public abstract boolean inSpaceQ();
	public abstract boolean inWaterQ();
	//deprecate roadgoing
	public weaponQ()
	{
		return false;
	}
	public vehicleQ()
	{
		return true;
	}
	
	
}