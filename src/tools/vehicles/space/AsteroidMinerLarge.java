package tools.vehicles.space;

import universe.ResourceDemand;

/**
 * Created by bob on 4/7/2016.
 */
public class AsteroidMinerLarge extends AsteroidMiner
{
	public static int MaxPassengersInitial;
	public static double maxWeightInitial;
	protected AsteroidMinerLarge(double resistance, double startHealth) {
		super(resistance, startHealth, MaxPassengersInitial, maxWeightInitial);
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
