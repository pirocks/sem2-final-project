package engine.tools.vehicles.space.factory;

import engine.universe.ResourceDemand;

/**
 * Created by bob on 4/7/2016.
 */
public class FactorySpaceCraftSmall extends FactorySpaceCraft {
	public static int MaxPassengersInitial;
	public static double maxWeightInitial;
	public static double startHealthInitial;
	public static double resistanceInitial;

	protected FactorySpaceCraftSmall() {
		super(resistanceInitial, startHealthInitial, MaxPassengersInitial, maxWeightInitial);
	}
	@Override
	public ResourceDemand requiredResourcesForConstruction() {
		return null;// TODO: 4/7/2016
	}

	@Override
	public long constructionManHours() {
		return 0;// TODO: 4/7/2016
	}

	@Override
	public double getWeight() {
		return 0;// TODO: 4/7/2016
	}
}
