package engine.tools.vehicles.space.interstellarcraft;

import engine.planets.LocationPlanet;
import engine.tools.AttackableConstants;
import engine.tools.vehicles.VehicleInitialConstants;
import engine.tools.vehicles.space.planetdestroyer.PlanetDestroyerLarge;
import engine.universe.ResourceDemand;

/**
 * Created by bob on 4/7/2016.
 *
 */
public class InterStellarCraftMedium extends InterStellarCraft
{
	public static int maxPassengersInitial = PlanetDestroyerLarge.maxPassengersInitial/90;
	public static double maxWeightInitial = PlanetDestroyerLarge.maxWeightInitial/90;
	public static double startHealthInitial = PlanetDestroyerLarge.startHealthInitial/90;
	public static double resistanceInitial = PlanetDestroyerLarge.resistanceInitial/90;

	protected InterStellarCraftMedium(LocationPlanet locationPlanet, int numToolsConstructor) {
		super(new VehicleInitialConstants(new AttackableConstants(startHealthInitial,resistanceInitial,
				locationPlanet),maxPassengersInitial,maxWeightInitial),numToolsConstructor);
	}

	@Override
	public double getSpeed() {
		return Double.MAX_VALUE/90/100;
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
