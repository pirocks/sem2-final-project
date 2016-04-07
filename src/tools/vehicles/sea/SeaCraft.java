package tools.vehicles.sea;

import tools.vehicles.Vehicle;

public abstract class SeaCraft extends Vehicle
{
	public boolean inWaterQ;

	protected SeaCraft(double resistance, double startHealth, int maxPassengers, double maxWeight) {
		super(resistance, startHealth, maxPassengers, maxWeight);
	}

	public boolean inSpaceQ()
	{
		return false;
	}
	public boolean inWaterQ()
	{
		return inWaterQ;
	}
}