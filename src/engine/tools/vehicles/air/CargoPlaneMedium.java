package engine.tools.vehicles.air;

import engine.tools.vehicles.VehicleInitialConstants;
import engine.universe.Resource;
import engine.universe.ResourceDemand;

import static engine.universe.Resource.Type.Oil;
import static engine.universe.Resource.Type.Silicon;

/**
 * Created by bob on 4/3/2016.
 *
 */
public class CargoPlaneMedium extends CargoPlane {
	public static double startHealthInitial = 2000;
	public static double resistanceInitial = 40;
	public static int maxPassengersInitial = 200;
	public static double maxWeightInitial = 600;

	protected CargoPlaneMedium(VehicleInitialConstants vehicleInitialConstants, int numToolsConstructor) {
		super(vehicleInitialConstants, numToolsConstructor);
	}


	@Override
	public ResourceDemand requiredResourcesForConstruction() {
		return new ResourceDemand(new Resource.Type[]{Resource.Type.Iron,Oil,Silicon},startHealthInitial,resistanceInitial,maxWeightInitial,maxPassengersInitial);
	}

	@Override
	public double getConstructionManDays() {
		return 8000;
	}
	@Override
	public double getSpeed() {
		return 3000;
	}
}
