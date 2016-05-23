package engine.tools.vehicles.space.interstellarcraft;

import engine.planets.LocationPlanet;
import engine.tools.AttackableConstants;
import engine.tools.vehicles.VehicleInitialConstants;
import engine.universe.ResourceDemand;

/**
 * Created by bob on 4/7/2016.
 *
 */
public class InterStellarCraftMedium extends InterStellarCraft
{
	public static int maxPassengersInitial;
	public static double maxWeightInitial;
	public static double startHealthInitial;
	public static double resistanceInitial;

	protected InterStellarCraftMedium(LocationPlanet locationPlanet, int numToolsConstructor) {
		super(new VehicleInitialConstants(new AttackableConstants(startHealthInitial,resistanceInitial,
				locationPlanet),maxPassengersInitial,maxWeightInitial),numToolsConstructor);
	}

	@Override
	public double getSpeed() {
		return 0;// TODO: 5/22/2016
	}

	@Override
	public ResourceDemand requiredResourcesForConstruction() {
		return null;// TODO: 5/22/2016
	}

	@Override
	public double getConstructionManDays() {
		return 0;// TODO: 5/22/2016
	}
}
