package engine.tools.vehicles.sea;

import engine.planets.LocationPlanet;
import engine.tools.AttackableConstants;
import engine.tools.vehicles.VehicleInitialConstants;
import engine.universe.Resource;
import engine.universe.ResourceDemand;

import static engine.universe.Resource.Type.Oil;
import static engine.universe.Resource.Type.Silicon;


/**
 * Created by bob on 4/3/2016.
 *
 */
public class TransporterMedium extends Transporter {
	public static int maxPassengersInitial = 5000;
	public static double maxWeightInitial = 75000;
	public static double startHealthInitial = 5000;
	public static double resistanceInitial = 1000;

	public TransporterMedium(LocationPlanet locationPlanet, int numToolsConstructor) {
		super(new VehicleInitialConstants(new AttackableConstants(startHealthInitial,resistanceInitial,locationPlanet),maxPassengersInitial,maxWeightInitial), numToolsConstructor);
	}


	@Override
	public double getSpeed() {
		return 200;
	}

	@Override
	public ResourceDemand requiredResourcesForConstruction() {
		return new ResourceDemand(new Resource.Type[]{Resource.Type.Iron,Oil,Silicon},startHealthInitial,resistanceInitial,maxWeightInitial,maxPassengersInitial);
	}

	@Override
	public double getConstructionManDays() {
		return 750000;
	}
}
