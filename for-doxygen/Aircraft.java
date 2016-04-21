package engine.tools.vehicles.air;

import engine.tools.vehicles.Vehicle;
import engine.tools.vehicles.VehicleInitialConstants;


public abstract class Aircraft extends Vehicle
{
    protected Aircraft(VehicleInitialConstants vehicleInitialConstants) {
        super(vehicleInitialConstants);
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