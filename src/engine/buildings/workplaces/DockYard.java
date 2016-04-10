package engine.buildings.workplaces;

import engine.cities.CityBlock;
import engine.tools.AttackableInitialConstants;
import engine.universe.MoneySource;
import engine.universe.ResourceDemand;

/**
 * Created by bob on 4/9/2016.
 *
 */
public class DockYard extends Workplace
{
	public static double healthInitial;
	public static double resistanceInitial;

	public static int maximumOccupancyInitial = -1;
	public static double costInitial;

	public DockYard(CityBlock parentBlock, MoneySource owner) {
		super(new AttackableInitialConstants(healthInitial,resistanceInitial), parentBlock, owner);
	}

	@Override
	public ResourceDemand getResourceCost() {
		return null;// TODO: 4/10/2016
	}

	@Override
	public double getCost() {
		return costInitial;
	}
}
