package engine.tools.vehicles.air;

import engine.universe.ResourceDemand;

/**
 * Created by bob on 4/3/2016.
 *
 */
public class FighterPlaneMedium extends FighterPlane{
	public static double startHealthInitial;
	public static double resistanceInitial;
	public static int maxPassengersInitial;
	public static double maxWeightInitial;
	public FighterPlaneMedium() {
		super(resistanceInitial, startHealthInitial, maxPassengersInitial, maxWeightInitial);
	}

	@Override
	public ResourceDemand requiredResourcesForConstruction() {
		return null;//// TODO: 4/7/2016
	}

	@Override
	public long constructionManHours() {
		return 0;//// TODO: 4/7/2016
	}

	@Override
	public double getWeight() {
		return 0;//// TODO: 4/7/2016
	}
}
