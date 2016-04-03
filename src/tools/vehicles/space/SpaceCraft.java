package tools.vehicles.space;

import tools.vehicles.Vehicle;

public abstract class SpaceCraft extends Vehicle
{
	public SpaceCraft(Type t)
	{
		super(t);

	}

	@Override
	public boolean inSpaceQ() {
		return false;
	}

	@Override
	public boolean inWaterQ() {
		return false;
	}
}