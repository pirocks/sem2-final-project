//fix constants here

package engine.buildings.housing;

import engine.cities.CityBlock;
import engine.people.cityworkers.CityWorker;
import engine.tools.AttackableInitialConstants;
import engine.universe.ResourceDemand;

import java.util.ArrayList;

public class ApartmentBlock extends Housing
{
	public static double resistanceInitial;
	public static double healthInitial;
	public static int maximumOccupancyInitial = 5000;

	public ApartmentBlock(CityBlock parentBlock) {
		super(new AttackableInitialConstants(healthInitial,resistanceInitial), parentBlock);
	}

	@Override
	public ResourceDemand getResourceCost() {
		return null;// TODO: 4/9/2016
	}
}