package engine.tools.vehicles.sea;

import engine.planets.LocationPlanet;
import engine.tools.vehicles.VehicleInitialConstants;
import engine.universe.ResourceDemand;

/**
 * Created by bob on 4/3/2016.
 *
 */
public class NuclearAircraftCarrier extends SeaCraft{
	public static int maxPassengersInitial;
	public static double maxWeightInitial;
	public static double startHealthInitial;
	public static double resistanceInitial;

	protected NuclearAircraftCarrier(LocationPlanet locationPlanet) {
		super(new VehicleInitialConstants(locationPlanet,
				startHealthInitial,
				resistanceInitial,
				maxPassengersInitial,
				maxWeightInitial));
	}

	@Override
	public ResourceDemand requiredResourcesForConstruction() {
		return null;//todo unimplmented
	}

	@Override
	public long constructionManHours() {
		return 0;//todo unimplmented
	}

	@Override
	public double getWeight() {
		return 0;//todo
	}
}
