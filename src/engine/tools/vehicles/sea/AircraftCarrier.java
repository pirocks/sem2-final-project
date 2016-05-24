package engine.tools.vehicles.sea;

import engine.tools.vehicles.VehicleInitialConstants;
import engine.universe.Resource;
import engine.universe.ResourceDemand;
import javafx.scene.image.Image;

import static engine.universe.Resource.Type.Oil;
import static engine.universe.Resource.Type.Silicon;

/**
 * Created by bob on 4/3/2016.
 *
 */
public class AircraftCarrier extends SeaCraft {
	public static int maxPassengersInitial = 5000;
	public static double maxWeightInitial = 30000;
	public static double startHealthInitial = 10000000;
	public static double resistanceInitial = 10000;

	protected AircraftCarrier(VehicleInitialConstants vehicleInitialConstants, int numToolsConstructor) {
		super(vehicleInitialConstants, numToolsConstructor);
	}

	@Override
	public double getSpeed() {
		return 150;
	}

	@Override
	public Image getImage() {
		return null;// TODO: 5/23/2016
	}

	@Override
	public ResourceDemand requiredResourcesForConstruction() {
		return new ResourceDemand(new Resource.Type[]{Resource.Type.Iron,Oil,Silicon},startHealthInitial,resistanceInitial,maxWeightInitial,maxPassengersInitial);
	}

	@Override
	public double getConstructionManDays() {
		return 6400000;
	}
}
