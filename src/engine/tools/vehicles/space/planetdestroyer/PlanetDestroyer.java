package engine.tools.vehicles.space.planetdestroyer;

import engine.tools.vehicles.space.SpaceCraft;

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
