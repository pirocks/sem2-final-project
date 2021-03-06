package engine.tools.vehicles.space.Freighter;

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
public class FreighterLarge extends Freighter
{
	public static int maxPassengersInitial = PlanetDestroyerLarge.maxPassengersInitial/300;
	public static double maxWeightInitial = PlanetDestroyerLarge.maxWeightInitial/100;
	public static double startHealthInitial = PlanetDestroyerLarge.startHealthInitial/500;
	public static double resistanceInitial = PlanetDestroyerLarge.resistanceInitial/500;


	protected FreighterLarge(LocationPlanet locationPlanet, int numToolsConstructor) {
		super(new VehicleInitialConstants(new AttackableConstants(startHealthInitial,resistanceInitial,
				locationPlanet),maxPassengersInitial,maxWeightInitial),numToolsConstructor);
	}

	@Override
	public double getSpeed() {
		return Double.MAX_VALUE/400/100;
	}

	@Override
	public ResourceDemand requiredResourcesForConstruction() {
		return new ResourceDemand(new Resource.Type[]{Resource.Type.Iron,Oil,Silicon,Uranium,Water},startHealthInitial,resistanceInitial,maxWeightInitial,maxPassengersInitial);
	}

	@Override
	public double getConstructionManDays() {
		return maxPassengersInitial*10*300/500;
	}
}
