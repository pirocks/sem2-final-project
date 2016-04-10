package engine.buildings.housing;

import engine.cities.CityBlock;
import engine.tools.AttackableConstants;
import engine.universe.ResourceDemand;


@Deprecated class WealthyWorkersHouseBlock extends Housing
{
	public static int maximumOccupancyInitial = 500;
	public static double resistanceInitial;

	public WealthyWorkersHouseBlock(AttackableConstants attackableConstants, CityBlock parentBlock) {
		super(attackableConstants,parentBlock);
	}

	@Override
	public ResourceDemand getResourceCost() {
		return null;// TODO: 4/9/2016
	}

//these classes do't really do anything
}