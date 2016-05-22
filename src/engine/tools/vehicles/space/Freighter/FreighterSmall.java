package engine.tools.vehicles.space.Freighter;

import engine.universe.ResourceDemand;

/**
 * Created by bob on 4/7/2016.
 */
public class FreighterSmall extends Freighter
{
	public static int maxPassengersInitial;
	public static double maxWeightInitial;
	public static double startHealthInitial;
	public static double resistanceInitial;


	@Override
	public double getSpeed() {
		return 0;
	}

	@Override
	public ResourceDemand requiredResourcesForConstruction() {
		return null;
	}

	@Override
	public double getconstructionManDays() {
		return 0;
	}
}
