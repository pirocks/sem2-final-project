package engine.tools.vehicles.space.shuttle;

import engine.tools.vehicles.VehicleInitialConstants;
import engine.universe.ResourceDemand;

/**
 * Created by bob on 4/7/2016.
 */
public class ShuttleMedium extends Shuttle
{
	public static int MaxPassengersInitial;
	public static double maxWeightInitial;
	public static double startHealthInitial;
	public static double resistanceInitial;

	protected ShuttleMedium() {
		super(new VehicleInitialConstants(
				startHealthInitial,
				resistanceInitial,
				MaxPassengersInitial,
				maxWeightInitial));
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
