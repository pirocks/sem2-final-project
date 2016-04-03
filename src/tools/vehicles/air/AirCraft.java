package tools.vehicles.air;

import tools.vehicles.Vehicle;


public abstract class Aircraft extends Vehicle
{
    public Aircraft(Type type) {
        super(type);
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