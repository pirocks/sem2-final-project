package engine.tools.vehicles.air;

import engine.planets.LocationPlanet;
import engine.tools.AttackableConstants;
import engine.tools.vehicles.VehicleInitialConstants;
import engine.universe.Resource;
import engine.universe.ResourceDemand;

import static engine.universe.Resource.Type.Oil;
import static engine.universe.Resource.Type.Silicon;

/**
 * Created by bob on 4/3/2016.
 *
 */
public class FighterPlaneSmall extends FighterPlane {
	public static double startHealthInitial = 1000;
	public static double resistanceInitial = 6000;
	public static int maxPassengersInitial = 1;
	public static double maxWeightInitial = 10;

	public FighterPlaneSmall(LocationPlanet locationPlanet, int numToolsConstructor) {
		super(new VehicleInitialConstants(new AttackableConstants(startHealthInitial,resistanceInitial,
				locationPlanet),maxPassengersInitial,maxWeightInitial),numToolsConstructor);
	}
	@Override
	public ResourceDemand requiredResourcesForConstruction() {
		return new ResourceDemand(new Resource.Type[]{Resource.Type.Iron,Oil,Silicon},startHealthInitial,resistanceInitial,maxWeightInitial,maxPassengersInitial);
	}

	@Override
	public double getConstructionManDays() {
		return 80000;
	}
	@Override
	public double getWeight() {
		return requiredResourcesForConstruction().getWeight();
	}

	@Override
	public double getSpeed() {
		return 10000;
	}
}
