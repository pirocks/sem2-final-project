package tools.vehicles.space;

/**
 * Created by bob on 4/7/2016.
 *
 */
public abstract class PlanetDestroyer extends SpaceCraft
{
	protected PlanetDestroyer(double resistance, double startHealth, int maxPassengers, double maxWeight) {
		super(resistance, startHealth, maxPassengers, maxWeight);
	}
}
