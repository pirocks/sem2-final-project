package engine.tools.vehicles.space;

import engine.planets.LocationPlanet;
import engine.tools.AttackableConstants;
import engine.tools.vehicles.VehicleInitialConstants;
import engine.universe.ResourceDemand;

/**
 * Created by bob on 4/7/2016.
 *
 */
public class Fighter extends SpaceCraft
{
	public static int MaxPassengersInitial;
	public static double maxWeightInitial;

	public static double startHealthInitial;
	public static double resistanceInitial;


	protected Fighter(LocationPlanet locationPlanet) {
		super(new VehicleInitialConstants(new AttackableConstants(startHealthInitial,resistanceInitial,locationPlanet),MaxPassengersInitial,maxWeightInitial));
	}


	@Override
	public ResourceDemand requiredResourcesForConstruction() {
		return null;// TODO: 4/7/2016
	}

	@Override
	public long constructionManHours() {
		return 0;// TODO: 4/7/2016
	}

	@Override
	public double getWeight() {
		return 0;// TODO: 4/7/2016
	}
}
