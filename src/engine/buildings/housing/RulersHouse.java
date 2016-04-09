package engine.buildings.housing;

import engine.cities.CityBlock;
import engine.people.cityworkers.CityWorker;

import java.util.ArrayList;

public class RulersHouse extends Housing
{
	public static int maximumOccupancyInitial = 10;
	public static double costInitial;
	public static double resistanceInitial;

	public RulersHouse(ArrayList<CityWorker> residents, CityBlock parentBlock) {
		super(residents, parentBlock);
	}
	//doesn't do much, but don't deprecate
}