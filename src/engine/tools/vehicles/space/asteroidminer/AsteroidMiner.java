package engine.tools.vehicles.space.asteroidminer;

import engine.tools.vehicles.VehicleInitialConstants;
import engine.tools.vehicles.space.SpaceCraft;

/**
 * Created by bob on 4/7/2016.
 */
public abstract class AsteroidMiner extends SpaceCraft {

	protected AsteroidMiner(VehicleInitialConstants vehicleInitialConstants, int numToolsConstructor) {
		super(vehicleInitialConstants, numToolsConstructor);
	}
}
