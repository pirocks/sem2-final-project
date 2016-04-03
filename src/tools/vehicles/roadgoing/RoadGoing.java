package tools.vehicles.roadgoing;

import tools.vehicles.Vehicle;

//possible deprecation b/c roads ot clear;y defined
public abstract class RoadGoing extends Vehicle//maaube extend land
{
	public RoadGoing(Type type) {
		super(type);
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