package engine.tools.vehicles.space.shuttle;

import engine.planets.LocationPlanet;
import engine.tools.AttackableConstants;
import engine.tools.vehicles.VehicleInitialConstants;
import engine.universe.Resource;
import engine.universe.ResourceDemand;

import static engine.universe.Resource.Type.*;

/**
 * Created by bob on 4/7/2016.
 *
 */
public class ShuttleLarge extends Shuttle {
	public static int maxPassengersInitial = ShuttleSmall.maxPassengersInitial/10;
	public static double maxWeightInitial = ShuttleSmall.maxWeightInitial/10;
	public static double startHealthInitial = ShuttleSmall.startHealthInitial/10;
	public static double resistanceInitial = ShuttleSmall.resistanceInitial/10;


	protected ShuttleLarge(LocationPlanet locationPlanet,int numToolsConstructor) {
		super(new VehicleInitialConstants(new AttackableConstants(startHealthInitial, resistanceInitial,
				locationPlanet), maxPassengersInitial, maxWeightInitial),numToolsConstructor);
	}

	@Override
	public double getSpeed() {
		return 30000;
	}

	@Override
	public ResourceDemand requiredResourcesForConstruction() {
		return new ResourceDemand(new Resource.Type[]{Resource.Type.Iron,Oil,Silicon,Uranium,Water},startHealthInitial,resistanceInitial,maxWeightInitial,maxPassengersInitial);
	}

	@Override
	public double getConstructionManDays() {
		return 0;// TODO: 5/22/2016
	}
}
