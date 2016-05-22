package engine.tools.vehicles.air;

import engine.planets.LocationPlanet;
import engine.tools.AttackableConstants;
import engine.tools.vehicles.VehicleInitialConstants;
import engine.universe.Resource;
import engine.universe.ResourceDemand;

import static engine.universe.Resource.Type.*;

/**
 * Created by bob on 4/3/2016.
 *
 */
public class FighterPlaneMedium extends FighterPlane{
	public static double startHealthInitial = 1000;
	public static double resistanceInitial = 10000;
	public static int maxPassengersInitial = 2;
	public static double maxWeightInitial = 10;


	protected FighterPlaneMedium(LocationPlanet locationPlanet, int numToolsConstructor) {
		super(new VehicleInitialConstants(new AttackableConstants(startHealthInitial,resistanceInitial,
				locationPlanet),maxPassengersInitial,maxWeightInitial),numToolsConstructor);
	}
	@Override
	public ResourceDemand requiredResourcesForConstruction() {
		return new ResourceDemand(new Resource.Type[] {Iron,Oil,Silicon},startHealthInitial,resistanceInitial,maxWeightInitial,maxPassengersInitial );
	}

	@Override
	public double getconstructionManDays() {
		return 160000;
	}

	@Override
	public double getSpeed() {
		return 10000;
	}
}
