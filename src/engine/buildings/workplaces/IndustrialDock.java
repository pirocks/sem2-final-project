































package engine.buildings.workplaces;

import engine.cities.CityBlock;
import engine.people.cityworkers.CityWorker;
import engine.universe.MoneySource;

import java.util.ArrayList;

public class IndustrialDock extends Workplace
{
	public static int maximumOccupancyInitial = 5000;
	public static double costInitial;
	public static double resistanceInitial;

	public IndustrialDock(ArrayList<CityWorker> workers, CityBlock parentBlock, MoneySource owner) {
		super(workers, parentBlock, owner);
	}
}