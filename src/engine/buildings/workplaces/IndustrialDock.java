package engine.buildings.workplaces;

import engine.cities.CityBlock;
import engine.people.cityworkers.CityWorker;
import engine.tools.AttackableInitialConstants;
import engine.universe.MoneySource;
import engine.universe.ResourceDemand;

import java.util.ArrayList;

public class IndustrialDock extends Workplace
{
	public static double resistanceInitial;
	public static double healthInitial;
	public static int maximumOccupancyInitial = 5000;

	public IndustrialDock(AttackableInitialConstants attackableInitialConstants,CityBlock parentBlock, MoneySource owner) {
		super(attackableInitialConstants, parentBlock, owner);
	}

	@Override
	public ResourceDemand getResourceCost() {
		return null;// TODO: 4/9/2016
	}

}