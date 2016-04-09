package engine.buildings.workplaces;

import engine.cities.CityBlock;
import engine.people.cityworkers.CityWorker;
import engine.universe.MoneySource;
import engine.universe.ResourceDemand;

import java.util.ArrayList;

public class IndustrialDock extends Workplace
{
	public static int maximumOccupancyInitial = 5000;
	public static double costInitial;
	public static double resistanceInitial;

	public IndustrialDock(ArrayList<CityWorker> workers, CityBlock parentBlock, MoneySource owner) {
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