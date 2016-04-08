package engine.tools.vehicles.space;

import engine.tools.vehicles.Vehicle;

public abstract class SpaceCraft extends Vehicle
{


	protected SpaceCraft(double resistance, double startHealth, int maxPassengers, double maxWeight) {
		super(resistance, startHealth, maxPassengers, maxWeight);
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