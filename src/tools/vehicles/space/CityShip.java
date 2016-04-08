package tools.vehicles.space;

import universe.ResourceDemand;

/**
 * Created by bob on 4/7/2016.
 */
public abstract class CityShip extends SpaceCraft
{

	protected CityShip(double resistance, double startHealth, int maxPassengers, double maxWeight) {
		super(resistance, startHealth, maxPassengers, maxWeight);
	}
}
