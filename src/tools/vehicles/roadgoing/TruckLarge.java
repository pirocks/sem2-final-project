package tools.vehicles.roadgoing;

import universe.ResourceDemand;

/**
 * Created by bob on 4/3/2016.
 */
public class TruckLarge extends Truck {
	public static int maxPassengersInitial;
	public static double maxWeightInitial;

	protected TransporterSmall(double resistance, double startHealth) {
		super(resistance, startHealth, maxPassengersInitial, maxWeightInitial);
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
