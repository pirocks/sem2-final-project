package engine.tools.vehicles.roadgoing;

import engine.universe.ResourceDemand;

/**
 * Created by bob on 4/3/2016.
 */
public class TruckSmall extends Truck {
	public static int maxPassengersInitial;
	public static double maxWeightInitial;
	public static double startHealthInitial;
	public static double resistanceInitial;

	protected TruckSmall() {
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
		return 0;//todo
	}
}
