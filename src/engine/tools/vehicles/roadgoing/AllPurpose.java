package engine.tools.vehicles.roadgoing;

import engine.tools.vehicles.VehicleInitialConstants;
import engine.universe.Resource;
import engine.universe.ResourceDemand;
import javafx.scene.image.Image;

import static engine.universe.Resource.Type.Oil;
import static engine.universe.Resource.Type.Silicon;

/**
 * Created by bob on 4/3/2016.
 */
public class AllPurpose extends RoadGoing {
	public static int maxPassengersInitial = 100;
	public static double maxWeightInitial = 1000;
	public static double startHealthInitial = 1000;
	public static double resistanceInitial = 1000;

	protected AllPurpose(VehicleInitialConstants vehicleInitialConstants, int numToolsConstructor) {
		super(vehicleInitialConstants, numToolsConstructor);
	}


	@Override
	public double getSpeed() {
		return 300;
	}

	@Override
	public Image getImage() {
		return null;
	}

	@Override
	public ResourceDemand requiredResourcesForConstruction() {
		return new ResourceDemand(new Resource.Type[]{Resource.Type.Iron,Oil,Silicon},startHealthInitial,resistanceInitial,maxWeightInitial,maxPassengersInitial);
	}

	@Override
	public double getConstructionManDays() {
		return 2000;
	}
}
