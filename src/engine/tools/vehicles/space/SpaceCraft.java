package engine.tools.vehicles.space;

import engine.tools.vehicles.Vehicle;
import engine.tools.vehicles.VehicleInitialConstants;
import javafx.scene.image.Image;

public abstract class SpaceCraft extends Vehicle
{


	protected SpaceCraft(VehicleInitialConstants vehicleInitialConstants, int numToolsConstructor) {
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

	@Override
	public Image getImage() {
		return null;
	}
}