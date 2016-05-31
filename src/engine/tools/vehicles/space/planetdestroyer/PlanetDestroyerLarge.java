package engine.tools.vehicles.space.planetdestroyer;

import engine.planets.LocationPlanet;
import engine.tools.AttackableConstants;
import engine.tools.vehicles.VehicleInitialConstants;
import engine.universe.ResourceDemand;


/**
 * Created by bob on 4/7/2016.
 *
 */
public class PlanetDestroyerLarge extends PlanetDestroyer {
	public static int maxPassengersInitial = 1000000;
	public static double maxWeightInitial = 10^8;
	public static double startHealthInitial = 10^13
			;
	public static double resistanceInitial = 10^11;

	protected PlanetDestroyerLarge(LocationPlanet locationPlanet, int numToolsConstructor) {
		super(new VehicleInitialConstants(new AttackableConstants(startHealthInitial,resistanceInitial,
				locationPlanet),maxPassengersInitial,maxWeightInitial),numToolsConstructor);
	}

	@Override
	public double getSpeed() {
		return Double.MAX_VALUE/100;
	}

	@Override
	public ResourceDemand requiredResourcesForConstruction() {
		return null;// TODO: 5/22/2016
	}

	@Override
	public double getConstructionManDays() {
		return maxPassengersInitial*10;
	}
}
