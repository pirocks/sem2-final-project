package engine.tools.vehicles.land;

import engine.planets.LocationPlanet;
import engine.tools.AttackableConstants;
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
public class ArmouredVehicle extends LandVehicle {
	public static int maxPassengersInitial = 20;
	public static double maxWeightInitial = 2000;
	public static double startHealthInitial = 10000;
	public static double resistanceInitial = 6000;

	protected ArmouredVehicle(int numToolsConstructor, LocationPlanet locationPlanet) {
		super(new VehicleInitialConstants(new AttackableConstants(startHealthInitial,resistanceInitial,locationPlanet),maxPassengersInitial,maxWeightInitial), numToolsConstructor);	}

	@Override
	public double getSpeed() {
		return 200;
	}

	@Override
	public Image getImage() {
		return null;
	}

	@Override
	public ResourceDemand requiredResourcesForConstruction() {
		return new ResourceDemand(new Resource.Type[]{Resource.Type.Iron,Oil,Silicon},startHealthInitial,resistanceInitial,maxWeightInitial,maxPassengersInitial);	}

	@Override
	public double getConstructionManDays() {
		return 8000;
	}
}
