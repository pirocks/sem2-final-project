package engine.buildings.workplaces;

import engine.cities.CityBlock;
import engine.people.cityworkers.CityWorker;
import engine.tools.AttackableConstants;
import engine.universe.MoneySource;
import engine.universe.Resource;
import engine.universe.ResourceDemand;

import java.util.ArrayList;

public class Warehouse extends Workplace
{
	public static double resistanceInitial;
	public static double healthInitial;
	//stores weighable object
	//resource or tool
	public static int maximumOccupancyInitial = -1;
	public static double costInitial;
	public Resource resources;

	public Warehouse(CityBlock parentBlock, MoneySource owner) {
		super(new AttackableConstants(healthInitial,resistanceInitial,parentBlock.getLocation()),parentBlock, owner);
	}
	@Override
	public ResourceDemand getResourceCost() {
		return null;// TODO: 4/9/2016
	}
}