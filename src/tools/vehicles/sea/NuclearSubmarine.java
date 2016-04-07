package tools.vehicles.sea;

import universe.ResourceDemand;

/**
 * Created by bob on 4/3/2016.
 *
 */
public class NuclearSubmarine extends SeaCraft {
	public static int maxPassengersInitial;
	public static double maxWeightInitial;

	protected NuclearSubmarine(double resistance, double startHealth) {
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
