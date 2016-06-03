package engine.tools.vehicles.space.Freighter;

import engine.planets.LocationPlanet;
import engine.tools.AttackableConstants;
import engine.tools.vehicles.VehicleInitialConstants;
import engine.universe.Resource;
import engine.universe.ResourceDemand;

import static engine.universe.Resource.Type.*;

/**
 * Created by bob on 4/7/2016.
 */
public class FreighterMedium extends Freighter {
	public static int maxPassengersInitial = FreighterLarge.maxPassengersInitial/3;
	public static double maxWeightInitial = FreighterLarge.maxWeightInitial/3;
	public static double startHealthInitial = FreighterLarge.startHealthInitial/3;
	public static double resistanceInitial = FreighterLarge.resistanceInitial/3;

	protected FreighterMedium(LocationPlanet locationPlanet, int numToolsConstructor) {
		super(new VehicleInitialConstants(new AttackableConstants(startHealthInitial,resistanceInitial,
				locationPlanet),maxPassengersInitial,maxWeightInitial),numToolsConstructor);
	}

	@Override
	public double getSpeed() {
		return Double.MAX_VALUE/400/100/3;
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
