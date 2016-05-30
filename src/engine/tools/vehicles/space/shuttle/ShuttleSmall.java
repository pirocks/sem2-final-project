package engine.tools.vehicles.space.shuttle;

import engine.planets.LocationPlanet;
import engine.tools.AttackableConstants;
import engine.tools.vehicles.VehicleInitialConstants;
import engine.tools.vehicles.air.FighterPlaneSmall;
import engine.universe.ResourceDemand;

/**
 * Created by bob on 4/7/2016.
 *
 */
public class ShuttleSmall extends Shuttle
{
	public static int maxPassengersInitial  = 5;
	public static double maxWeightInitial= 50;
	public static double startHealthInitial = FighterPlaneSmall.startHealthInitial;
	public static double resistanceInitial = FighterPlaneSmall.resistanceInitial;

	public ShuttleSmall(LocationPlanet locationPlanet, int numToolsConstructor) {
		super(new VehicleInitialConstants(new AttackableConstants(startHealthInitial,resistanceInitial, locationPlanet),maxPassengersInitial,maxWeightInitial),numToolsConstructor);
	}


	@Override
	public double getSpeed() {
		return 20000;
	}

	@Override
	public ResourceDemand requiredResourcesForConstruction() {
		return null;// TODO: 5/22/2016
	}

	@Override
	public double getConstructionManDays() {
		return 0;// TODO: 5/22/2016
	}
}
