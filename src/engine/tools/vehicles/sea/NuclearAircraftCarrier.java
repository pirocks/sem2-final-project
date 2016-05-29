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
public class NuclearAircraftCarrier extends SeaCraft{
	public static int maxPassengersInitial = 7000;
	public static double maxWeightInitial = 40000;
	public static double startHealthInitial = 20000000;
	public static double resistanceInitial = 100000;

	public NuclearAircraftCarrier(LocationPlanet locationPlanet, int numToolsConstructor) {
		super(new VehicleInitialConstants(new AttackableConstants(startHealthInitial,resistanceInitial,locationPlanet),maxPassengersInitial,maxWeightInitial), numToolsConstructor);
	}

	@Override
	public double getSpeed() {
		return 400;
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
		return 9600000;
	}
}
