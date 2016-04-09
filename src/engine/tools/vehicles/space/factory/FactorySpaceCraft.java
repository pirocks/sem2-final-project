package engine.tools.vehicles.space.factory;

import engine.tools.vehicles.space.SpaceCraft;

/**
 * Created by bob on 4/7/2016.
 */
public abstract class FactorySpaceCraft extends SpaceCraft
{
	protected FactorySpaceCraft(double resistance, double startHealth, int maxPassengers, double maxWeight) {
		super(resistance, startHealth, maxPassengers, maxWeight);
	}
}
