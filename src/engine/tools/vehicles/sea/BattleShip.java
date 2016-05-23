package engine.tools.vehicles.sea;

import engine.tools.vehicles.VehicleInitialConstants;
import engine.universe.Resource;
import engine.universe.ResourceDemand;

import static engine.universe.Resource.Type.Oil;
import static engine.universe.Resource.Type.Silicon;

/**
 * Created by bob on 4/3/2016.
 *
 */
public class BattleShip extends SeaCraft {
	public static int maxPassengersInitial = 1500;
	public static double maxWeightInitial = 9000;
	public static double startHealthInitial = 7500000;
	public static double resistanceInitial = 100000;

	protected BattleShip(VehicleInitialConstants vehicleInitialConstants, int numToolsConstructor) {
		super(vehicleInitialConstants, numToolsConstructor);
	}


	@Override
	public double getSpeed() {
		return 150;
	}

	@Override
	public ResourceDemand requiredResourcesForConstruction() {
		return new ResourceDemand(new Resource.Type[]{Resource.Type.Iron,Oil,Silicon},startHealthInitial,resistanceInitial,maxWeightInitial,maxPassengersInitial);	}

	@Override
	public double getConstructionManDays() {
		return 3200000;
	}
}
