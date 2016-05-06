package engine.buildings.housing;

import engine.cities.CityBlock;
import engine.people.cityworkers.CityWorker;
import engine.tools.AttackableConstants;
import engine.universe.ResourceDemand;

import java.util.ArrayList;

public class RulersHouse extends Housing
{
	public static double healthInitial;
	public static double resistanceInitial;
	public static int maximumOccupancyInitial = 10;
	public static double costInitial;

	public RulersHouse(ArrayList<CityWorker> residents, CityBlock parentBlock) {
		super(new AttackableConstants(parentBlock.getLocation(),healthInitial,resistanceInitial), parentBlock);
	}

	@Override
	public ResourceDemand getResourceCost() {
		return null; // TODO: 4/9/2016
	}

	//doesn't do much, but don't deprecate
}