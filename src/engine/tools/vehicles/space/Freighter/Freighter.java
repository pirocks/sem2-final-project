package engine.tools.vehicles.space.Freighter;

import engine.tools.vehicles.VehicleInitialConstants;
import engine.tools.vehicles.space.SpaceCraft;

/**
 * Created by bob on 4/7/2016.
 *
 */
public abstract class Freighter extends SpaceCraft
{

	protected Freighter(VehicleInitialConstants vehicleInitialConstants, int numToolsConstructor) {
		super(vehicleInitialConstants, numToolsConstructor);
	}
}
