package engine.tools.vehicles.air;

import engine.tools.vehicles.VehicleInitialConstants;
import engine.universe.Resource;
import engine.universe.ResourceDemand;

import static engine.universe.Resource.Type.*;

/**
 * Created by bob on 4/3/2016.
 *
 */
public class CargoPlaneSmall extends CargoPlane
{
	public static double startHealthInitial = 1000;
	public static double resistanceInitial = 20;
	public static int maxPassengersInitial = 100;
	public static double maxWeightInitial = 200;

	protected CargoPlaneSmall(VehicleInitialConstants vehicleInitialConstants, int numToolsConstructor) {
		super(vehicleInitialConstants, numToolsConstructor);
	}


	@Override
	public ResourceDemand requiredResourcesForConstruction() {
		return  new ResourceDemand(new Resource.Type[] {Iron,Oil,Silicon},startHealthInitial,resistanceInitial,maxWeightInitial,maxPassengersInitial);
	}

	@Override
	public double getConstructionManDays() {
		return 4000;
	}

	@Override
	public double getSpeed() {
		return 2500;
	}
}
