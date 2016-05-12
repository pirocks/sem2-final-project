package engine.buildings.workplaces;

import engine.cities.CityBlock;
import engine.people.cityworkers.CityWorker;
import engine.tools.AttackableConstants;
import engine.universe.MoneySource;
import engine.universe.ResourceDemand;

import java.util.ArrayList;

public class School extends Workplace
{
	public static double healthInitial;
	public static double resistanceInitial;
	public static int maximumOccupancyInitial = -1;

	public School(CityBlock parentBlock, MoneySource owner) {
		super(new AttackableConstants(healthInitial,resistanceInitial,parentBlock.getLocation()), parentBlock, owner);
	}

	@Override
	public ResourceDemand getResourceCost() {
		return null;// TODO: 4/9/2016
	}

	//no member vars needed, teachers have all vars required
	
}