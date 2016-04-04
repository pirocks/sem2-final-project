
package buildings.housing;

import cities.CityBlock;
import trash.CityWorker;

import java.util.ArrayList;

public class WorkersHouseBlock extends Housing
{
	public static int maximumOccupancyInitial = 1000;
	public static double costInitial;
	public static double resistanceInitial;

	public WorkersHouseBlock(Type type, ArrayList<CityWorker> residents, CityBlock parentBlock)
	{
		super(type, residents, parentBlock);
	}
}