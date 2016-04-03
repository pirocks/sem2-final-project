
























package buildings.workplaces;

import buildings.Workplace;
import cities.City;
import cities.CityBlock;
import people.CityWorker;
import universe.MoneySource;

import java.util.ArrayList;

public class TownHall extends Workplace
{
	private City parentCity;//money for city
	public static int maximumOccupancyInitial = 10;
	public static double costInitial;
	public static double resistanceInitial;

	public TownHall(Type type, ArrayList<CityWorker> workers, CityBlock parentBlock, MoneySource owner) {
		super(type, workers, parentBlock, owner);
	}
}