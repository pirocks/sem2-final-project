




























package buildings.workplaces;

import buildings.Workplace;
import cities.CityBlock;
import people.CityWorker;
import universe.MoneySource;
import universe.Resource;

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