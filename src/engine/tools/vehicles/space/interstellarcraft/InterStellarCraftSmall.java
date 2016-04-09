package engine.tools.vehicles.space.interstellarcraft;

import engine.universe.ResourceDemand;

//import static engine.planets.Road.resistance;

/**
 * Created by bob on 4/7/2016.
 */
public class InterStellarCraftSmall extends InterStellarCraft
{
	public static int MaxPassengersInitial;
	public static double maxWeightInitial;
	public static double startHealthInitial;
	public static double resistanceInitial;

	protected InterStellarCraftSmall() {
		super(resistanceInitial, startHealthInitial, MaxPassengersInitial, maxWeightInitial);
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
