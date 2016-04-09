
package engine.buildings.housing;

import engine.cities.CityBlock;
import engine.people.cityworkers.CityWorker;
import engine.universe.ResourceDemand;

import java.util.ArrayList;

public class WorkersHouseBlock extends Housing
{
	public static int maximumOccupancyInitial = 1000;
	public static double costInitial;
	public static double resistanceInitial;

	public WorkersHouseBlock(ArrayList<CityWorker> residents, CityBlock parentBlock)
	{
		super(residents, parentBlock);
	}

	@Override
	public ResourceDemand getResourceCost() {
		return null;// TODO: 4/9/2016
	}

	@Override
	public double getCost() {
		return 0;// TODO: 4/9/2016
	}
}