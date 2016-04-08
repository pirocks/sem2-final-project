package engine.tools.vehicles.space;

/**
 * Created by bob on 4/7/2016.
 *
 */
public abstract class InterStellarCraft extends SpaceCraft {
	protected InterStellarCraft(double resistance, double startHealth, int maxPassengers, double maxWeight) {
		super(resistance, startHealth, maxPassengers, maxWeight);
	}
}
