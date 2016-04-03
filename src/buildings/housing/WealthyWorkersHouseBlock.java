




























package buildings.housing;

import buildings.Housing;
import cities.CityBlock;
import people.CityWorker;

import java.util.ArrayList;

//deprecate??
public class WealthyWorkersHouseBlock extends Housing
{
	public static int maximumOccupancyInitial = 500;
	public static double costInitial;
	public static double resistanceInitial;

	public WealthyWorkersHouseBlock(Type type, ArrayList<CityWorker> residents, CityBlock parentBlock) {
		super(type, residents, parentBlock);
	}
//these classes do't really do anything
}