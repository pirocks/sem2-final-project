package tools.vehicles.sea;

import universe.ResourceDemand;

/**
 * Created by bob on 4/3/2016.
 *
 */
public class TransporterLarge extends Transporter {
	public static int maxPassengersInitial;
	public static double maxWeightInitial;

	protected TransporterLarge(double resistance, double startHealth) {
		super(resistance, startHealth, maxPassengersInitial, maxWeightInitial);
	}

	@Override
	public ResourceDemand requiredResourcesForConstruction() {
		return null;//todo unimlmented
	}

	@Override
	public long constructionManHours() {
		return 0;//todo unimplemented
	}

	@Override
	public double getWeight() {
		return 0;//todo unimplemented
	}
}
