package engine.buildings.housing;

import engine.cities.CityBlock;
import engine.tools.AttackableConstants;
import engine.universe.ResourceDemand;

public class RulersHouse extends Housing
{
	public static double healthInitial;
	public static double resistanceInitial;
	public static int maximumOccupancyInitial = 10;
	public static double costInitial;

	public RulersHouse(CityBlock parentBlock) {
		super(new AttackableConstants(parentBlock.getLocation(),healthInitial,resistanceInitial), parentBlock);
	}

	@Override
	protected String getName() {
		return "RulersHouse";
	}

	@Override
	public ResourceDemand getResourceCost() {
		return null; // TODO: 4/9/2016
	}

	//doesn't do much, but don't deprecate
}