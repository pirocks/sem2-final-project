package engine.tools.vehicles.air;

import engine.tools.vehicles.Vehicle;
import engine.tools.vehicles.VehicleInitialConstants;


public abstract class Aircraft extends Vehicle
{
    public static double startHealthAdd = 0;

    protected Aircraft(VehicleInitialConstants vehicleInitialConstants, int numToolsConstructor) {
        super(vehicleInitialConstants.addHealth(startHealthAdd), numToolsConstructor);
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