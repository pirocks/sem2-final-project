package engine.buildings.workplaces;

import engine.cities.CityBlock;
import engine.people.cityworkers.CityWorker;
import engine.science.Discovery;
import engine.tools.AttackableConstants;
import engine.universe.MoneySource;
import engine.universe.ResourceDemand;

import java.util.ArrayList;

public class ResearchArea extends Workplace
{
	public static double healthInitial;
	public static double resistanceInitial;
	public static int maximumOccupancyInitial = -1;
	private Discovery discovery;

	public ResearchArea(CityBlock parentBlock, MoneySource owner) {
		super(new AttackableConstants(healthInitial,resistanceInitial,parentBlock.getLocation()), parentBlock, owner);
	}

	@Override
	public ResourceDemand getResourceCost() {
		return null;// TODO: 4/9/2016
	}

}