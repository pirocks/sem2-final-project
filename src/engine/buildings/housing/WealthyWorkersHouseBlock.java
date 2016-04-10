package engine.buildings.housing;

import engine.cities.CityBlock;
import engine.people.cityworkers.CityWorker;
import engine.tools.AttackableInitialConstants;
import engine.universe.ResourceDemand;

import java.util.ArrayList;


@Deprecated class WealthyWorkersHouseBlock extends Housing
{
	public static int maximumOccupancyInitial = 500;
	public static double resistanceInitial;

	public WealthyWorkersHouseBlock(AttackableInitialConstants attackableInitialConstants, CityBlock parentBlock) {
		super(attackableInitialConstants,parentBlock);
	}

	@Override
	public ResourceDemand getResourceCost() {
		return null;// TODO: 4/9/2016
	}

//these classes do't really do anything
}