package tools.vehicles.land;

import universe.ResourceDemand;

/**
 * Created by bob on 4/3/2016.
 *
 */
public class AutomatedArtillery extends LandVehicle {
	public static int maxPassengersInitial;
	public static double maxWeightInitial;

	protected AutomatedArtillery(double resistance, double startHealth) {
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
