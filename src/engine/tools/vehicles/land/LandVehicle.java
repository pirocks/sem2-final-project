package engine.tools.vehicles.land;

import engine.tools.vehicles.Vehicle;

public abstract class LandVehicle extends Vehicle
{
	protected LandVehicle(double resistance, double startHealth, int maxPassengers, double maxWeight) {
		super(resistance, startHealth, maxPassengers, maxWeight);
	}

	public boolean inSpaceQ()
	{
		return false;
	}
	public boolean inWaterQ()
	{
		return false;
	}
}