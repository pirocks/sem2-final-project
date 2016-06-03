package engine.tools.vehicles.space;

import engine.tools.vehicles.Vehicle;
import engine.tools.vehicles.VehicleInitialConstants;
import javafx.scene.image.Image;

public abstract class SpaceCraft extends Vehicle
{


	public static double startHealthMult = 1;

	protected SpaceCraft(VehicleInitialConstants vehicleInitialConstants, int numToolsConstructor) {
		super(vehicleInitialConstants.startHealthMult(startHealthMult), numToolsConstructor);
	}

	@Override
	public boolean inSpaceQ() {
		return false;
	}

	@Override
	public boolean inWaterQ() {
		return false;
	}

	@Override
	public Image getImage() {
		return null;
	}
}