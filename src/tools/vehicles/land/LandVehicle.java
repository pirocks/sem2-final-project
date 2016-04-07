package tools.vehicles.land;

import tools.vehicles.Vehicle;
import universe.ResourceDemand;

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

	@Override
	public ResourceDemand requiredResourcesForConstruction() {
		return null;
	}

	@Override
	public long constructionManHours() {
		return 0;
	}
}