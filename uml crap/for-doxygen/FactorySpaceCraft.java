package engine.tools.vehicles.space.factory;

import engine.tools.vehicles.VehicleInitialConstants;
import engine.tools.vehicles.space.SpaceCraft;

/**
 * Created by bob on 4/7/2016.
 */
public abstract class FactorySpaceCraft extends SpaceCraft
{
	protected FactorySpaceCraft(VehicleInitialConstants vehicleInitialConstants) {
		super(vehicleInitialConstants);
	}
}
