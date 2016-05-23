package engine.buildings.workplaces;

import engine.cities.City;
import engine.cities.CityBlock;
import engine.tools.AttackableConstants;
import engine.universe.MoneySource;
import engine.universe.ResourceDemand;

public class TownHall extends Workplace
{
	public static double healthInitial;
	public static double resistanceInitial;
	private City parentCity;//money for city
	public static int maxWorkersInitial = 10;// TODO: 5/19/2016 magic cnstant
	public static double costInitial;

	public TownHall( CityBlock parentBlock, MoneySource owner) {
		super(new AttackableConstants(parentBlock.getLocation(),healthInitial,resistanceInitial), parentBlock, maxWorkersInitial, owner);
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