package tools.vehicles.roadgoing;

import tools.vehicles.Vehicle;

//possible deprecation b/c roads ot clear;y defined
public abstract class RoadGoing extends Vehicle//maaube extend land
{
	protected RoadGoing(double resistance, double startHealth, int maxPassengers, double maxWeight) {
		super(resistance, startHealth, maxPassengers, maxWeight);
	}

	public boolean inWaterQ()
	{
		return false;
	}
	public boolean inSpaceQ()
	{
		return false;
	}
}