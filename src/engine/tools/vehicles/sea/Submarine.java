package engine.tools.vehicles.sea;

import engine.tools.vehicles.VehicleInitialConstants;
import engine.universe.Resource;
import engine.universe.ResourceDemand;
import javafx.scene.image.Image;

import static engine.universe.Resource.Type.*;

/**
 * Created by bob on 4/3/2016.
 *
 */
public class Submarine extends SeaCraft {

	public static int maxPassengersInitial = 400;
	public static double maxWeightInitial =  1500;
	public static double startHealthInitial = 750000;
	public static double resistanceInitial = 50000;

	protected Submarine(VehicleInitialConstants vehicleInitialConstants, int numToolsConstructor) {
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
		return new ResourceDemand(new Resource.Type[]{Resource.Type.Iron,Oil,Silicon,Water},startHealthInitial,resistanceInitial,maxWeightInitial,maxPassengersInitial);
	}

	@Override
	public double getConstructionManDays() {
		return 2500000;
	}
}
