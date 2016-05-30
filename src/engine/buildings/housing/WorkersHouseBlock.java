
package engine.buildings.housing;

import engine.cities.CityBlock;
import engine.tools.AttackableConstants;
import engine.universe.ResourceDemand;

public class WorkersHouseBlock extends Housing
{
	public static double healthInitial = 5000;
	public static double resistanceInitial = 250;
	public static int maximumOccupancyInitial = 1000;

	public WorkersHouseBlock(CityBlock parentBlock) {
		super(new AttackableConstants(parentBlock.getLocation(),healthInitial,resistanceInitial),parentBlock);
	}

	@Override
	protected String getName() {
		return "WorkersHouseBlock";
	}

	@Override
	public ResourceDemand getResourceCost() {
		return null;// TODO: 4/9/2016
	}




}