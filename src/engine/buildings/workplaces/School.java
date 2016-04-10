package engine.buildings.workplaces;

import engine.cities.CityBlock;
import engine.people.cityworkers.CityWorker;
import engine.universe.MoneySource;
import engine.universe.ResourceDemand;

import java.util.ArrayList;

public class School extends Workplace
{
	public static int maximumOccupancyInitial = -1;
	public static double costInitial;
	public static double resistanceInitial;

	public School(ArrayList<CityWorker> workers, CityBlock parentBlock, MoneySource owner) {
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
	//no member vars needed, teachers have all vars required
	
}