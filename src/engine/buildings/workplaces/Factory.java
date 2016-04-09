package engine.buildings.workplaces;

import engine.cities.CityBlock;
import engine.people.cityworkers.CityWorker;
import engine.tools.Tool;
import engine.universe.MoneySource;
import engine.universe.ResourceDemand;

import java.util.ArrayList;

public class Factory extends Workplace
{
	// TODO: 4/9/2016 how is this going to work
	//only builds weapons/ vehicles roadgoing or otherwise
	public static int maximumOccupancyInitial = -1;
	public static double costInitial;
	public static double resistanceInitial;
	public double toolProgress = 0.0; //form 0 to 1
	public Tool inProduction;

	public Factory(ArrayList<CityWorker> workers, CityBlock parentBlock, MoneySource owner) {
		super(workers, parentBlock, owner);
	}

	@Override
	public ResourceDemand getResourceCost() {
		return null;// TODO: 4/9/2016
	}

	@Override
	public double getCost() {
		return 0;// TODO: 4/9/2016
	}
}