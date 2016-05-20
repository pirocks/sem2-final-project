package engine.buildings.workplaces;

import engine.cities.CityBlock;
import engine.tools.AttackableConstants;
import engine.universe.MoneySource;
import engine.universe.ResourceDemand;

public class IndustrialDock extends Workplace
{
	public static double resistanceInitial;
	public static double healthInitial;
	public static int maxWorkersInitial = 5000;

	public IndustrialDock(CityBlock parentBlock, MoneySource owner) {
		super(new AttackableConstants(healthInitial,resistanceInitial,parentBlock.getLocation()), parentBlock, maxWorkersInitial, owner);
	}

	@Override
	protected String getName() {
		return "IndustrialDock";
	}

	@Override
	public ResourceDemand getResourceCost() {
		return null;// TODO: 4/9/2016
	}

}