
























package engine.buildings.workplaces;

import engine.cities.City;
import engine.cities.CityBlock;
import engine.people.cityworkers.CityWorker;
import engine.universe.MoneySource;

import java.util.ArrayList;

public class TownHall extends Workplace
{
	private City parentCity;//money for city
	public static int maximumOccupancyInitial = 10;
	public static double costInitial;
	public static double resistanceInitial;

	public TownHall(ArrayList<CityWorker> workers, CityBlock parentBlock, MoneySource owner) {
		super(workers, parentBlock, owner);
	}
}