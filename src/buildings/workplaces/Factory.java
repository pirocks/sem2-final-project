



























package buildings.workplaces;
import buildings.*;
import universe.UniqueId;
import cities.Building;

public class Factory extends Workplace
{
    public static int maximumOccupancyInitial = -1;
	public static double costInitial;
	public static double resistanceInitial;
	public double toolProgress = 0.0; //form 0 to 1
	public Tool inProduction;
}