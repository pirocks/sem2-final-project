package engine.tools.vehicles.sea;

import engine.universe.ResourceDemand;

/**
 * Created by bob on 4/3/2016.
 */
public class Destroyer extends SeaCraft {
	public static int maxPassengersInitial;
	public static double maxWeightInitial;

	protected Destroyer(double resistance, double startHealth) {
		super(resistance, startHealth, maxPassengersInitial, maxWeightInitial);
	}

	@Override
	public ResourceDemand requiredResourcesForConstruction() {
		return null;//todo unimplmented
	}

	@Override
	public long constructionManHours() {
		return 0;//todo unimplmented
	}

	@Override
	public double getWeight() {
		return 0;//todo unimplmented
	}
}
