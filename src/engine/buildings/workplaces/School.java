package engine.buildings.workplaces;

import engine.cities.CityBlock;
import engine.tools.AttackableConstants;
import engine.universe.MoneySource;
import engine.universe.ResourceDemand;

public class School extends Workplace
{
	public static double healthInitial;
	public static double resistanceInitial;
	public static int maxWorkersInitial;// TODO: 5/19/2016

	public School(CityBlock parentBlock, MoneySource owner) {
		super(new AttackableConstants(healthInitial,resistanceInitial,parentBlock.getLocation()), parentBlock, maxWorkersInitial, owner);
	}

	@Override
	protected String getName() {
		return "School";
	}

	@Override
	public ResourceDemand getResourceCost() {
		return null;// TODO: 4/9/2016
	}

	//no member vars needed, teachers have all vars required
	
}