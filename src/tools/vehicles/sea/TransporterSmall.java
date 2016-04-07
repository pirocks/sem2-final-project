package tools.vehicles.sea;

import universe.ResourceDemand;

/**
 * Created by bob on 4/3/2016.
 *
 */
public class TransporterSmall extends Transporter {
	public static int maxPassengersInitial;
	public static double maxWeightInitial;

	protected TransporterSmall(double resistance, double startHealth) {
		super(resistance, startHealth, maxPassengersInitial, maxWeightInitial);
	}

	@Override
	public ResourceDemand requiredResourcesForConstruction() {
		return null;
	}

	@Override
	public long constructionManHours() {
		return 0;
	}

	@Override
	public double getWeight() {
		return 0;
	}
}
