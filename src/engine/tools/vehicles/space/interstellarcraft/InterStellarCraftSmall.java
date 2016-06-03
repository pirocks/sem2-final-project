package engine.tools.vehicles.space.interstellarcraft;

import engine.planets.LocationPlanet;
import engine.tools.AttackableConstants;
import engine.tools.vehicles.VehicleInitialConstants;
import engine.tools.vehicles.space.planetdestroyer.PlanetDestroyerLarge;
import engine.universe.Resource;
import engine.universe.ResourceDemand;

import static engine.universe.Resource.Type.*;


/**
 * Created by bob on 4/7/2016.
 */
public class InterStellarCraftSmall extends InterStellarCraft
{
	public static int maxPassengersInitial = PlanetDestroyerLarge.maxPassengersInitial/300;
	public static double maxWeightInitial = PlanetDestroyerLarge.maxWeightInitial/300;
	public static double startHealthInitial = PlanetDestroyerLarge.startHealthInitial/300;
	public static double resistanceInitial = PlanetDestroyerLarge.resistanceInitial/300;

	protected InterStellarCraftSmall(LocationPlanet locationPlanet, int numToolsConstructor) {
		super(new VehicleInitialConstants(new AttackableConstants(startHealthInitial,resistanceInitial,
				locationPlanet),maxPassengersInitial,maxWeightInitial),numToolsConstructor);
	}

	@Override
	public double getSpeed() {
		return Double.MAX_VALUE/100/300;
	}

	@Override
	public ResourceDemand requiredResourcesForConstruction() {
		return new ResourceDemand(new Resource.Type[]{Resource.Type.Iron,Oil,Silicon,Uranium,Water},startHealthInitial,resistanceInitial,maxWeightInitial,maxPassengersInitial);
	}

	@Override
	public double getConstructionManDays() {
		return maxPassengersInitial*10;
	}
}
