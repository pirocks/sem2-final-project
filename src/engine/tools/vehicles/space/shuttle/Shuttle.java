package engine.tools.vehicles.space.shuttle;

import engine.tools.vehicles.VehicleInitialConstants;
import engine.tools.vehicles.space.SpaceCraft;

/**
 * Created by bob on 4/7/2016.
 */
public abstract class Shuttle extends SpaceCraft
{

	protected Shuttle(VehicleInitialConstants vehicleInitialConstants, int numToolsConstructor) {
		super(vehicleInitialConstants, numToolsConstructor);
	}
}
