




























package buildings.housing;

import cities.CityBlock;
import people.cityworkers.CityWorker;

import java.util.ArrayList;

public class RulersHouse extends Housing
{
	public static int maximumOccupancyInitial = 10;
	public static double costInitial;
	public static double resistanceInitial;

	public RulersHouse(Type type, ArrayList<CityWorker> residents, CityBlock parentBlock) {
		super(type, residents, parentBlock);
	}
	//doesn't do much, but don't deprecate
}