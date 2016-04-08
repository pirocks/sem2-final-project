




























package engine.buildings.workplaces;

import engine.cities.CityBlock;
import engine.people.cityworkers.CityWorker;
import engine.universe.MoneySource;
import engine.universe.Resource;

import java.util.ArrayList;

public class Warehouse extends Workplace
{
	public static int maximumOccupancyInitial = -1;
	public static double costInitial;
	public static double resistanceInitial;
	public Resource resources;

	public Warehouse(Type type, ArrayList<CityWorker> workers, CityBlock parentBlock, MoneySource owner) {
		super(type, workers, parentBlock, owner);
	}
}