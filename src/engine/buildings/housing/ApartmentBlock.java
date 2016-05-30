//fix constants here

package engine.buildings.housing;

import engine.cities.CityBlock;
import engine.tools.AttackableConstants;
import engine.universe.ResourceDemand;

public class ApartmentBlock extends Housing
{
	public static double resistanceInitial = 1000;
	public static double healthInitial = 10000;
	public static int maximumOccupancyInitial = 5000;

	public ApartmentBlock(CityBlock parentBlock) {
		super(new AttackableConstants(parentBlock.getLocation(),healthInitial,resistanceInitial), parentBlock);
	}

	@Override
	protected String getName() {
		return "Apartment Block";
	}

	@Override
	public ResourceDemand getResourceCost() {
		return null;// TODO: 4/9/2016
	}

}