package engine.tools.vehicles.sea;

import engine.tools.vehicles.Vehicle;
import engine.tools.vehicles.VehicleInitialConstants;

public abstract class SeaCraft extends Vehicle
{
	protected boolean inWaterQ = false;

	protected SeaCraft(VehicleInitialConstants vehicleInitialConstants) {
		super(vehicleInitialConstants, numToolsConstructor);
	}


	public boolean inSpaceQ()
	{
		return false;
	}
	public boolean inWaterQ()
	{
		return inWaterQ;
	}
}