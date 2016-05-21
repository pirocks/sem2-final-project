package engine.tools.vehicles.sea;

import engine.planets.LocationPlanet;
import engine.tools.AttackableConstants;
import engine.tools.vehicles.VehicleInitialConstants;
import engine.universe.ResourceDemand;

//import static engine.planets.Road.resistance;

//import static engine.planets.Road.resistance;

//import static engine.planets.Road.resistance;

/**
 * Created by bob on 4/3/2016.
 *
 */
public class NuclearSubmarine extends SeaCraft {
	public static int maxPassengersInitial;
	public static double maxWeightInitial;
	public static double startHealthInitial;
	public static double resistanceInitial;

	protected NuclearSubmarine(LocationPlanet locationPlanet) {
		super(new VehicleInitialConstants(new AttackableConstants(startHealthInitial,resistanceInitial,locationPlanet),maxPassengersInitial,maxWeightInitial));
	}
	@Override
	public ResourceDemand requiredResourcesForConstruction() {
		return null;//todo unimplmented
	}

	@Override
	public double getconstructionManDays() {
		return 0;
	}

	@Override
	public double getWeight() {
		return 0;//todo unimplmented
	}
}
