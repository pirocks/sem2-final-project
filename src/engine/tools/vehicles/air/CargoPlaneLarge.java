package engine.tools.vehicles.air;

import engine.tools.vehicles.VehicleInitialConstants;
import engine.universe.Resource;
import engine.universe.ResourceDemand;

import static engine.universe.Resource.Type.Oil;
import static engine.universe.Resource.Type.Silicon;

/**
 * Created by bob on 4/3/2016.
 */
public class CargoPlaneLarge extends CargoPlane {
	public static double startHealthInitial = 10000;
	public static double resistanceInitial = 200;
	public static int maxPassengersInitial = 1000;
	public static double maxWeightInitial = 3000;

	protected CargoPlaneLarge(VehicleInitialConstants vehicleInitialConstants, int numToolsConstructor) {
		super(vehicleInitialConstants, numToolsConstructor);
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
	public double getSpeed() {
		return 5000;
	}
}
