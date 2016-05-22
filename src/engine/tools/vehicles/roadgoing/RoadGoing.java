package engine.tools.vehicles.roadgoing;

import engine.tools.vehicles.Vehicle;
import engine.tools.vehicles.VehicleInitialConstants;

//possible deprecation b/c roads ot clear;y defined
public abstract class RoadGoing extends Vehicle//maaube extend land
{
	protected RoadGoing(VehicleInitialConstants vehicleInitialConstants) {
		super(vehicleInitialConstants, numToolsConstructor);
	}

	public boolean inWaterQ()
	{
		return false;
	}
	public boolean inSpaceQ()
	{
		return false;
	}
}