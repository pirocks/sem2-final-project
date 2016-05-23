package engine.tools.vehicles.land;

import engine.tools.vehicles.VehicleInitialConstants;
import engine.universe.Resource;
import engine.universe.ResourceDemand;

import static engine.universe.Resource.Type.Oil;
import static engine.universe.Resource.Type.Silicon;

/**
 * Created by bob on 4/3/2016.
 *
 */
public class AutomatedArmouredVehicle extends LandVehicle {
	public static int maxPassengersInitial = 30;
	public static double maxWeightInitial = 2000;
	public static double startHealthInitial = 10000;
	public static double resistanceInitial = 6000;

	protected AutomatedArmouredVehicle(VehicleInitialConstants vehicleInitialConstants, int numToolsConstructor) {
		super(vehicleInitialConstants, numToolsConstructor);
	}

	@Override
	public double getSpeed() {
		return 200;
	}

	@Override
	public ResourceDemand requiredResourcesForConstruction() {
		return new ResourceDemand(new Resource.Type[]{Resource.Type.Iron,Oil,Silicon},startHealthInitial,resistanceInitial,maxWeightInitial,maxPassengersInitial);	}

	@Override
	public double getConstructionManDays() {
		return 8000;
	}
}
