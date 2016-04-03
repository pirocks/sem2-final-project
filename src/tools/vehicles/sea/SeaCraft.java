package tools.vehicles.sea;

import tools.vehicles.Vehicle;











public abstract class SeaCraft extends Vehicle
{
	public boolean inWaterQ;
	public SeaCraft(Type t)
	{
		super(t);

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