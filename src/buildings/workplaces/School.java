






















package buildings.workplaces;

import cities.CityBlock;
import trash.CityWorker;
import universe.MoneySource;

import java.util.ArrayList;

public class School extends Workplace
{
	public static int maximumOccupancyInitial = -1;
	public static double costInitial;
	public static double resistanceInitial;

	public School(Type type, ArrayList<CityWorker> workers, CityBlock parentBlock, MoneySource owner) {
		super(type, workers, parentBlock, owner);
	}
	//no member vars needed, teachers have all vars required
	
}