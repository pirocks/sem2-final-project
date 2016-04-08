package engine.tools.vehicles.space;

/**
 * Created by bob on 4/7/2016.
 */
public abstract class Shuttle extends SpaceCraft
{
	protected Shuttle(double resistance, double startHealth, int maxPassengers, double maxWeight) {
		super(resistance, startHealth, maxPassengers, maxWeight);
	}
}
