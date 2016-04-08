package engine.tools.vehicles.air;

import engine.universe.ResourceDemand;

/**
 * Created by bob on 4/3/2016.
 *
 */
public class CargoPlaneMedium extends CargoPlane {
	public static int maxPassengersInitial;
	public static double maxWeightInitial;

	protected CargoPlaneMedium(double resistance, double startHealth) {
		super(resistance, startHealth, maxPassengersInitial, maxWeightInitial);
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
