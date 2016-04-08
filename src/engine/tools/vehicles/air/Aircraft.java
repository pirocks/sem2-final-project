package engine.tools.vehicles.air;

import engine.tools.vehicles.Vehicle;


public abstract class Aircraft extends Vehicle
{
    protected Aircraft(double resistance, double startHealth, int maxPassengers, double maxWeight) {
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