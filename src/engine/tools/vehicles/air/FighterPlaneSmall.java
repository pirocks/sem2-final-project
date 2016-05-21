package engine.tools.vehicles.air;

import engine.planets.LocationPlanet;
import engine.tools.AttackableConstants;
import engine.tools.vehicles.VehicleInitialConstants;
import engine.universe.ResourceDemand;

/**
 * Created by bob on 4/3/2016.
 *
 */
public class FighterPlaneSmall extends FighterPlane {
	public static double startHealthInitial;
	public static double resistanceInitial;
	public static int maxPassengersInitial;
	public static double maxWeightInitial;

	protected FighterPlaneSmall(LocationPlanet locationPlanet) {
		super(new VehicleInitialConstants(new AttackableConstants(startHealthInitial,resistanceInitial,locationPlanet),maxPassengersInitial,maxWeightInitial));
	}
	@Override
	public ResourceDemand requiredResourcesForConstruction() {
		return null;//todo
	}

	@Override
	public long getManDaysForConstruction() {
		return 0;//todo
	}

	@Override
	public double getWeight() {
		return 0;//// TODO: 4/7/2016
	}
}
