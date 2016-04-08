package engine.tools.vehicles.sea;

import engine.universe.ResourceDemand;

/**
 * Created by bob on 4/3/2016.
 *
 */
public class AircraftCarrier extends SeaCraft {
	public static int MaxPassengersInitial;
	public static double maxWeightInitial;
	public static double startHealthInitial;
	public static double resistanceInitial;

	protected AircraftCarrier() {
		super(resistanceInitial, startHealthInitial, MaxPassengersInitial, maxWeightInitial);
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
