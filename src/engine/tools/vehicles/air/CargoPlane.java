package engine.tools.vehicles.air;

/**
 * Created by bob on 4/3/2016.
 */
public abstract class CargoPlane extends  Aircraft {
	protected CargoPlane(double resistance, double startHealth, int maxPassengers, double maxWeight) {
		super(resistance, startHealth, maxPassengers, maxWeight);
	}
}
