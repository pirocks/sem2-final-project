


























//fix constants here

package buildings.housing;

import buildings.Housing;
import cities.CityBlock;
import people.CityWorker;

import java.util.ArrayList;

public class ApartmentBlock extends Housing
{
	public static int maximumOccupancyInitial = 5000;
	public static double costInitial;
	public static double resistanceInitial;

	public ApartmentBlock(Type type, ArrayList<CityWorker> residents, CityBlock parentBlock) {
		super(type, residents, parentBlock);
	}
}