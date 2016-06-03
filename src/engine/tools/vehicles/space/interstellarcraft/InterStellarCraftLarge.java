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
		return Double.MAX_VALUE/30/100;
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
