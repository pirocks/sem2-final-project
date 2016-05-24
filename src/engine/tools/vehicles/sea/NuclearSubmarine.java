package engine.tools.vehicles.sea;

import engine.tools.vehicles.VehicleInitialConstants;
import engine.universe.Resource;
import engine.universe.ResourceDemand;
import javafx.scene.image.Image;

import static engine.universe.Resource.Type.*;

//import static engine.planets.Road.resistance;

//import static engine.planets.Road.resistance;

//import static engine.planets.Road.resistance;

/**
 * Created by bob on 4/3/2016.
 *
 */
public class NuclearSubmarine extends SeaCraft {
	public static int maxPassengersInitial = 500;
	public static double maxWeightInitial  = 2000;
	public static double startHealthInitial = 1000000;
	public static double resistanceInitial = 50000;

	protected NuclearSubmarine(VehicleInitialConstants vehicleInitialConstants, int numToolsConstructor) {
		super(vehicleInitialConstants, numToolsConstructor);
	}

	@Override
	public double getSpeed() {
		return 350;
	}

	@Override
	public Image getImage() {
		return null;
	}

	@Override
	public ResourceDemand requiredResourcesForConstruction() {
		return new ResourceDemand(new Resource.Type[]{Resource.Type.Iron,Oil,Silicon,Uranium,Water},startHealthInitial,resistanceInitial,maxWeightInitial,maxPassengersInitial);
	}

	@Override
	public double getConstructionManDays() {
		return 5000000;
	}
}
