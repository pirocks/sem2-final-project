package engine.tools.vehicles.sea;

import engine.planets.LocationPlanet;
import engine.tools.AttackableConstants;
import engine.tools.vehicles.VehicleInitialConstants;
import engine.universe.Resource;
import engine.universe.ResourceDemand;
import javafx.scene.image.Image;

import static engine.universe.Resource.Type.*;


/**
 * Created by bob on 4/3/2016.
 *
 */
public class NuclearSubmarine extends SeaCraft {
	public static int maxPassengersInitial = 500;
	public static double maxWeightInitial  = 2000;
	public static double startHealthInitial = 1000000;
	public static double resistanceInitial = 50000;

	public NuclearSubmarine(LocationPlanet locationPlanet, int numToolsConstructor) {
		super(new VehicleInitialConstants(new AttackableConstants(startHealthInitial,resistanceInitial,locationPlanet),maxPassengersInitial,maxWeightInitial), numToolsConstructor);
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
