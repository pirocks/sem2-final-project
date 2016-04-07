package tools.vehicles.sea;

import tools.vehicles.Vehicle;

public abstract class SeaCraft extends Vehicle
{
	public boolean inWaterQ;
	public SeaCraft()
	{

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