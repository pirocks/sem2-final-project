package engine.buildings.workplaces;

import engine.cities.CityBlock;
import engine.tools.AttackableConstants;
import engine.universe.MoneySource;
import engine.universe.Resource;
import engine.universe.ResourceDemand;

public class Warehouse extends Workplace
{
	public static double resistanceInitial;
	public static double healthInitial;
	//stores weighable object
	//resource or tool
	public static int maxiWorkersInitial;
	public static double costInitial;
	public Resource resources;

	public Warehouse(CityBlock parentBlock, MoneySource owner) {
		super(new AttackableConstants(healthInitial,resistanceInitial,parentBlock.getLocation()),parentBlock, maxiWorkersInitial, owner);
	}

	@Override
	protected String getName() {
		return "WareHouse";
	}

	@Override
	public ResourceDemand getResourceCost() {
		return null;// TODO: 4/9/2016
	}
}