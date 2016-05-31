package engine.tools.vehicles.space.asteroidminer;

import engine.planets.LocationPlanet;
import engine.tools.AttackableConstants;
import engine.tools.vehicles.VehicleInitialConstants;
import engine.universe.ResourceDemand;

/**
 * Created by bob on 4/7/2016.
 *
 */
public class AsteroidMinerLarge extends AsteroidMiner
{
	public static int maxPassengersInitial = AsteroidMinerSmall.maxPassengersInitial*2;
	public static double maxWeightInitial = AsteroidMinerSmall.maxWeightInitial*2;
	public static double startHealthInitial = AsteroidMinerSmall.startHealthInitial*2;
	public static double resistanceInitial = AsteroidMinerSmall.resistanceInitial*2;

	protected AsteroidMinerLarge(LocationPlanet locationPlanet, int numToolsConstructor) {
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
