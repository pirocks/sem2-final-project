package engine.buildings.workplaces;

import engine.cities.CityBlock;
import engine.people.cityworkers.CityWorker;
import engine.tools.AttackableInitialConstants;
import engine.tools.Tool;
import engine.universe.MoneySource;
import engine.universe.ResourceDemand;

import java.util.ArrayList;

public class Factory extends Workplace
{
	public static double healthInitial;
	public static double resistanceInitial;
	// TODO: 4/9/2016 how is this going to work
	//only builds weapons/ vehicles roadgoing or otherwise
	public static int maximumOccupancyInitial = -1;
	public static double costInitial;
	public double toolProgress = 0.0; //form 0 to 1
	public Tool inProduction;

	public Factory(CityBlock parentBlock, MoneySource owner) {
		super(new AttackableInitialConstants(healthInitial,resistanceInitial), parentBlock, owner);
	}

	@Override
	public ResourceDemand getResourceCost() {
		return null;// TODO: 4/9/2016
	}

	@Override
	public double getCost() {
		return costInitial;
	}
}