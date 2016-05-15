package engine.buildings.workplaces;

import engine.cities.City;
import engine.cities.CityBlock;
import engine.people.cityworkers.CityWorker;
import engine.tools.AttackableConstants;
import engine.universe.MoneySource;
import engine.universe.ResourceDemand;

import java.util.ArrayList;

public class TownHall extends Workplace
{
	public static double healthInitial;
	public static double resistanceInitial;
	private City parentCity;//money for city
	public static int maximumOccupancyInitial = 10;
	public static double costInitial;

	public TownHall(ArrayList<CityWorker> workers, CityBlock parentBlock, MoneySource owner) {
		super(new AttackableConstants(parentBlock.getLocation(),healthInitial,resistanceInitial), parentBlock, owner);
	}

	@Override
	protected String getName() {
		return "TownHall";
	}

	@Override
	public ResourceDemand getResourceCost() {
		return null;// TODO: 4/9/2016
	}

}