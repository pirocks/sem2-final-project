package engine.tools.vehicles;

/**
 * Created by bob on 4/4/2016.
 *
 */
public interface VehicleContainer
{
	void remove(Vehicle vehicle);
	default void registerVehicleContainer()
	{
		VehicleContainers.registerContainer(this);
	}
}
