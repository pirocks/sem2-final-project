package engine.tools.vehicles.space;

import engine.tools.vehicles.Vehicle;
import engine.tools.vehicles.VehicleInitialConstants;

public abstract class SpaceCraft extends Vehicle
{

	protected SpaceCraft(VehicleInitialConstants vehicleInitialConstants) {
		super(vehicleInitialConstants, numToolsConstructor);
	}

	@Override
	public boolean inSpaceQ() {
		return false;
	}

	@Override
	public boolean inWaterQ() {
		return false;
	}
}