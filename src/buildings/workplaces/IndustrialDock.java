































package buildings.workplaces;

import cities.CityBlock;
import people.cityworkers.CityWorker;
import universe.MoneySource;

import java.util.ArrayList;

public class IndustrialDock extends Workplace
{
	public static int maximumOccupancyInitial = 5000;
	public static double costInitial;
	public static double resistanceInitial;

	public IndustrialDock(Type type, ArrayList<CityWorker> workers, CityBlock parentBlock, MoneySource owner) {
		super(type, workers, parentBlock, owner);
	}
}