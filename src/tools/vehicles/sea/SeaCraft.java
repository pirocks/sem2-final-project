package tools.vehicles.sea;

import tools.vehicles.*;











public class SeaCraft extends Vehicle
{
	public boolean inWaterQ;
	public SeaCraft()
	{
		
	}
	public abstract boolean spaceQ()
	{
		return false;
	}
	public abstract boolean seaQ()
	{
		return true;
	}
	public abstract boolean landQ()
	{
		return false;
	}
	public abstract boolean roadgoingQ()
	{
		return false;
	}
	public abstract boolean inSpaceQ()
	{
		
	}
	public abstract boolean inWaterQ()
	{
		
	}
}