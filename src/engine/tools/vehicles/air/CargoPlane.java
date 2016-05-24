package engine.tools.vehicles.air;

import engine.tools.vehicles.VehicleInitialConstants;
import javafx.scene.image.Image;

/**
 * Created by bob on 4/3/2016.
 */
public abstract class CargoPlane extends  Aircraft {

	protected CargoPlane(VehicleInitialConstants vehicleInitialConstants, int numToolsConstructor) {
		super(vehicleInitialConstants, numToolsConstructor);
	}

	@Override
	public Image getImage() {
		return null;
	}
}
