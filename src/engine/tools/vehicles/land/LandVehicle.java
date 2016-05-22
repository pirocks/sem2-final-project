package engine.tools.vehicles.land;

import engine.tools.vehicles.Vehicle;
import engine.tools.vehicles.VehicleInitialConstants;

public abstract class LandVehicle extends Vehicle
{

	protected LandVehicle(VehicleInitialConstants vehicleInitialConstants, int numToolsConstructor) {
		super(vehicleInitialConstants, numToolsConstructor);
	}

	public boolean inSpaceQ()
	{
		return false;
	}
	public boolean inWaterQ()
	{
		return false;
	}
}