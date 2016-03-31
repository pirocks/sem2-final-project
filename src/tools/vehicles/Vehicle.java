



















package tools.vehicles;
import universe.*;
import java.util.ArrayList;
import cities.AbstractPerson;

public class Vehicle
{
	// public Location location;
	private ArrayList<AbstractPerson> passengers;
	private ArrayList<Resource> cargo;
	private ArrayList<MoneySource> money;//could just use a bureucrat as passenger
	public static enum Type
	{
		Land,Sea,Space,Aircraft
	}
	private Type type;//not sure if this is necesary
	public Vehicle()
	{
		
	}
	
}