package engine.tools.vehicles.space.interstellarcraft;

import engine.tools.vehicles.VehicleInitialConstants;
import engine.universe.ResourceDemand;

/**
 * Created by bob on 4/7/2016.
 *
 */
public class InterStellarCraftMedium extends InterStellarCraft
{
	public static int MaxPassengersInitial;
	public static double maxWeightInitial;
	public static double startHealthInitial;
	public static double resistanceInitial;

	protected InterStellarCraftMedium() {
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
