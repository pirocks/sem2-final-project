package tools.vehicles.land;

import tools.vehicles.Vehicle;
import universe.ResourceDemand;

public abstract class LandVehicle extends Vehicle
{
	public LandVehicle(Type type) {
		super(type);
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