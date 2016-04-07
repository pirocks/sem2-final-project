package tools.vehicles.sea;

import universe.ResourceDemand;

/**
 * Created by bob on 4/3/2016.
 *
 */
public class AircraftCarrier extends SeaCraft {
	public static int MaxPassengersInitial;
	public static double maxWeightInitial;
	protected AircraftCarrier(double resistance, double startHealth) {
		super(resistance, startHealth, MaxPassengersInitial, maxWeightInitial);
	}

	@Override
	public ResourceDemand requiredResourcesForConstruction() {
		return null;//todo unimplemented
	}

	@Override
	public long constructionManHours() {
		return 0;//todo unimplemted
	}

	@Override
	public double getWeight() {
		return 0;//todo unimpleemented
	}
}
