package engine.tools.vehicles.space;

/**
 * Created by bob on 4/7/2016.
 *
 */
public abstract class Freighter extends SpaceCraft
{

	protected Freighter(double resistance, double startHealth, int maxPassengers, double maxWeight) {
		super(resistance, startHealth, maxPassengers, maxWeight);
	}
}