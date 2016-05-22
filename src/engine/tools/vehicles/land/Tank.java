package engine.tools.vehicles.land;

import engine.tools.vehicles.VehicleInitialConstants;
import engine.tools.weapons.guns.artillery.TankArtillery;
import engine.universe.Resource;
import engine.universe.ResourceDemand;

import static engine.universe.Resource.Type.Oil;
import static engine.universe.Resource.Type.Silicon;

/**
 * Created by bob on 4/3/2016.
 *
 */
public class Tank extends LandVehicle {
	public static int maxPassengersInitial = 4;
	public static double maxWeightInitial = 500 + new TankArtillery(1).getWeight();
	public static double startHealthInitial = 20000;
	public static double resistanceInitial = 20000;

	protected Tank(VehicleInitialConstants vehicleInitialConstants, int numToolsConstructor) {
		super(vehicleInitialConstants, numToolsConstructor);
	}


	@Override
	public double getSpeed() {
		return 90;
	}

	@Override
	public ResourceDemand requiredResourcesForConstruction() {
		return new ResourceDemand(new Resource.Type[]{Resource.Type.Iron,Oil,Silicon},startHealthInitial,resistanceInitial,maxWeightInitial,maxPassengersInitial);	}

	@Override
	public double getconstructionManDays() {
		return 10000;
	}
}
