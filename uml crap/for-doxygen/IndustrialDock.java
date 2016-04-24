package engine.buildings.workplaces;

import engine.cities.CityBlock;
import engine.tools.AttackableConstants;
import engine.universe.MoneySource;
import engine.universe.ResourceDemand;

public class IndustrialDock extends Workplace
{
	public static double resistanceInitial;
	public static double healthInitial;
	public static int maximumOccupancyInitial = 5000;

	public IndustrialDock(AttackableConstants attackableConstants, CityBlock parentBlock, MoneySource owner) {
		super(attackableConstants, parentBlock, owner);
	}

	@Override
	public ResourceDemand getResourceCost() {
		return null;// TODO: 4/9/2016
	}

}