package engine.tools.vehicles.space.planetdestroyer;

import engine.planets.LocationPlanet;
import engine.tools.AttackableConstants;
import engine.tools.vehicles.VehicleInitialConstants;
import engine.universe.ResourceDemand;

/**
 * Created by bob on 4/7/2016.
 */
public class PlanetDestroyerMedium extends PlanetDestroyer {
	public static int maxPassengersInitial = PlanetDestroyerLarge.maxPassengersInitial/3;
	public static double maxWeightInitial = PlanetDestroyerLarge.maxWeightInitial/3;
	public static double startHealthInitial = PlanetDestroyerLarge.startHealthInitial/3;
	public static double resistanceInitial = PlanetDestroyerLarge.resistanceInitial/3;


	protected PlanetDestroyerMedium(LocationPlanet locationPlanet, int numToolsConstructor) {
		super(new VehicleInitialConstants(new AttackableConstants(startHealthInitial,resistanceInitial,
				locationPlanet),maxPassengersInitial,maxWeightInitial),numToolsConstructor);
	}

	@Override
	public double getSpeed() {
		return Double.MAX_VALUE/300;
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
