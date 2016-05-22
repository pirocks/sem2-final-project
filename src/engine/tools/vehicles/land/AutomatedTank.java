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
public class AutomatedTank extends LandVehicle {
	public static int maxPassengersInitial = 0;
	public static double maxWeightInitial = 500 + Tank.maxWeightInitial;
	public static double startHealthInitial = 30000;
	public static double resistanceInitial = 20000;

	protected AutomatedTank(VehicleInitialConstants vehicleInitialConstants, int numToolsConstructor) {
		super(vehicleInitialConstants, numToolsConstructor);
	}


	@Override
	public double getSpeed() {
		return 120;
	}

	@Override
	public ResourceDemand requiredResourcesForConstruction() {
		return new ResourceDemand(new Resource.Type[]{Resource.Type.Iron,Oil,Silicon},startHealthInitial,resistanceInitial,maxWeightInitial,maxPassengersInitial);	}

	@Override
	public double getconstructionManDays() {
		return 10000;
	}
}
