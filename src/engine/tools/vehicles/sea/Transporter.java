package engine.tools.vehicles.sea;

import engine.tools.vehicles.VehicleInitialConstants;

/**
 * Created by bob on 4/3/2016.
 *
 */
public abstract class Transporter extends SeaCraft {

	protected Transporter(VehicleInitialConstants vehicleInitialConstants, int numToolsConstructor) {
		super(vehicleInitialConstants, numToolsConstructor);
	}
}
