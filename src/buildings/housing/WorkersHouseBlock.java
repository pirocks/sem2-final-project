





























package buildings.housing;

import buildings.Housing;
import cities.CityBlock;
import people.CityWorker;

import java.util.ArrayList;

public class WorkersHouseBlock extends Housing
{
	public static int maximumOccupancyInitial = 1000;
	public static double costInitial;
	public static double resistanceInitial;

	public WorkersHouseBlock(Type type, ArrayList<CityWorker> residents, CityBlock parentBlock) {
		super(type, residents, parentBlock);
	}
//these classes don't really do anything
}