package engine.tools.vehicles.air;

/**
 * Created by bob on 4/3/2016.
 *
 */
public abstract class FighterPlane extends Aircraft {
	protected FighterPlane(double resistance, double startHealth, int maxPassengers, double maxWeight) {
		super(resistance, startHealth, maxPassengers, maxWeight);
	}
}
