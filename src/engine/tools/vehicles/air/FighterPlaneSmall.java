package engine.tools.vehicles.air;

import engine.universe.ResourceDemand;

/**
 * Created by bob on 4/3/2016.
 *
 */
public class FighterPlaneSmall extends FighterPlane {
	public static double startHealthInitial;
	public static double resistanceInitial;
	public static int maxPassengersInitial;
	public static double maxWeightInitial;
	public FighterPlaneSmall() {
		super(resistanceInitial, startHealthInitial, maxPassengersInitial, maxWeightInitial);
	}

	@Override
	public ResourceDemand requiredResourcesForConstruction() {
		return null;//todo
	}

	@Override
	public long constructionManHours() {
		return 0;//todo
	}

	@Override
	public double getWeight() {
		return 0;//// TODO: 4/7/2016
	}
}
