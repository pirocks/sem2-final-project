package engine.tools.vehicles.space.shuttle;

import engine.planets.LocationPlanet;
import engine.tools.AttackableConstants;
import engine.tools.vehicles.VehicleInitialConstants;
import engine.universe.ResourceDemand;

/**
 * Created by bob on 4/7/2016.
 */
public class ShuttleMedium extends Shuttle
{
	public static int maxPassengersInitial = ShuttleSmall.maxPassengersInitial*2;
	public static double maxWeightInitial = ShuttleSmall.maxWeightInitial*2;
	public static double startHealthInitial = ShuttleSmall.startHealthInitial*2;
	public static double resistanceInitial = ShuttleSmall.resistanceInitial*2;

	public ShuttleMedium(LocationPlanet locationPlanet, int numToolsConstructor) {
		super(new VehicleInitialConstants(new AttackableConstants(startHealthInitial,resistanceInitial,
				locationPlanet),maxPassengersInitial,maxWeightInitial),numToolsConstructor);
	}

	@Override
	public double getSpeed() {
		return 30000;
	}

	@Override
	public ResourceDemand requiredResourcesForConstruction() {
		return null; // TODO: 5/22/2016
	}

	@Override
	public double getConstructionManDays() {
		return 0; // TODO: 5/22/2016
	}
}
