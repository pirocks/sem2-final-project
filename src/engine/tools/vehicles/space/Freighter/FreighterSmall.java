package engine.tools.vehicles.space.Freighter;

import engine.tools.vehicles.VehicleInitialConstants;
import engine.universe.ResourceDemand;

/**
 * Created by bob on 4/7/2016.
 */
public class FreighterSmall extends Freighter
{
	public static int maxPassengersInitial;// TODO: 5/22/2016
	public static double maxWeightInitial;// TODO: 5/22/2016
	public static double startHealthInitial;// TODO: 5/22/2016
	public static double resistanceInitial;// TODO: 5/22/2016

	protected FreighterSmall(VehicleInitialConstants vehicleInitialConstants, int numToolsConstructor) {
		super(vehicleInitialConstants, numToolsConstructor);// TODO: 5/22/2016
	}


	@Override
	public double getSpeed() {
		return 0;// TODO: 5/22/2016
	}

	@Override
	public ResourceDemand requiredResourcesForConstruction() {
		return null;// TODO: 5/22/2016
	}

	@Override
	public double getconstructionManDays() {
		return 0;// TODO: 5/22/2016
	}
}
