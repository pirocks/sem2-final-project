package engine.tools.vehicles.space.interstellarcraft;

import engine.planets.LocationPlanet;
import engine.tools.AttackableConstants;
import engine.tools.vehicles.VehicleInitialConstants;
import engine.tools.vehicles.space.planetdestroyer.PlanetDestroyerLarge;
import engine.universe.ResourceDemand;

/**
 * Created by bob on 4/7/2016.
 */
public class InterStellarCraftLarge extends InterStellarCraft {
	public static int maxPassengersInitial = PlanetDestroyerLarge.maxPassengersInitial/30;
	public static double maxWeightInitial = PlanetDestroyerLarge.maxWeightInitial/30;
	public static double startHealthInitial = PlanetDestroyerLarge.startHealthInitial/30;
	public static double resistanceInitial = PlanetDestroyerLarge.resistanceInitial/30;

	protected InterStellarCraftLarge(LocationPlanet location,int numToolsConstructor) {
		super(new VehicleInitialConstants(new AttackableConstants(startHealthInitial,resistanceInitial,location),
				maxPassengersInitial,maxWeightInitial) ,
				numToolsConstructor);
	}


	@Override
	public double getSpeed() {
		return Double.MAX_VALUE/30/100;// TODO: 5/22/2016
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
