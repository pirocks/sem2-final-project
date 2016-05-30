package engine.tools.vehicles.air;

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
public class Helicopter extends Aircraft {
	public static int maxPassengersInitial = 5;
	public static double maxWeightInitial = 100;
	public static double startHealthInitial = 1000;
	public static double resistanceInitial = 500;


	public Helicopter(LocationPlanet locationPlanet, int numToolsConstructor) {
		super(new VehicleInitialConstants(new AttackableConstants(startHealthInitial,resistanceInitial,locationPlanet),maxPassengersInitial,maxWeightInitial),numToolsConstructor);
	}
	@Override
	public ResourceDemand requiredResourcesForConstruction() {
		return new ResourceDemand(new Resource.Type[]{Resource.Type.Iron,Oil,Silicon},startHealthInitial,resistanceInitial,maxWeightInitial,maxPassengersInitial);
	}

	@Override
	public double getConstructionManDays() {
		return 20000;
	}

	@Override
	public double getSpeed() {
		return 1000;
	}

	@Override
	public Image getImage() {
		return new Image(getClass().getResourceAsStream("helicopterImage.jpg"));
	}
}
