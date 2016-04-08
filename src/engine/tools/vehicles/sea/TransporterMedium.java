package engine.tools.vehicles.sea;

import engine.universe.ResourceDemand;

//import static engine.planets.Road.resistance;

/**
 * Created by bob on 4/3/2016.
 *
 */
public class TransporterMedium extends Transporter {
	public static int maxPassengersInitial;
	public static double maxWeightInitial;
	public static double startHealthInitial;
	public static double resistanceInitial;

	protected TransporterMedium() {
		super(resistanceInitial, startHealthInitial, maxPassengersInitial, maxWeightInitial);
	}

	@Override
	public ResourceDemand requiredResourcesForConstruction() {
		return null;//todo unimplemented
	}

	@Override
	public long constructionManHours() {
		return 0;//todo unimplemented
	}

	@Override
	public double getWeight() {
		return 0;//todo unimplemented
	}
}
