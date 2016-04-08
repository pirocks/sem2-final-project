



























package engine.buildings.workplaces;

import engine.cities.CityBlock;
import engine.people.cityworkers.CityWorker;
import engine.tools.Tool;
import engine.universe.MoneySource;

import java.util.ArrayList;

public class Factory extends Workplace
{
    public static int maximumOccupancyInitial = -1;
	public static double costInitial;
	public static double resistanceInitial;
	public double toolProgress = 0.0; //form 0 to 1
	public Tool inProduction;

	public Factory(Type type, ArrayList<CityWorker> workers, CityBlock parentBlock, MoneySource owner) {
		super(type, workers, parentBlock, owner);
	}
}