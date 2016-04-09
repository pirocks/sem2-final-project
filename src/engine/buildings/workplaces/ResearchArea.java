





























package engine.buildings.workplaces;

import engine.cities.CityBlock;
import engine.people.cityworkers.CityWorker;
import engine.science.Discovery;
import engine.universe.MoneySource;

import java.util.ArrayList;

public class ResearchArea extends Workplace
{
	public static int maximumOccupancyInitial = -1;
	public static double costInitial;
	public static double resistanceInitial;
	private Discovery discovery;

	public ResearchArea(ArrayList<CityWorker> workers, CityBlock parentBlock, MoneySource owner) {
		super(workers, parentBlock, owner);
	}
}