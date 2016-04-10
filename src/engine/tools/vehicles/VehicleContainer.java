package engine.tools.vehicles;

/**
 * Created by bob on 4/4/2016.
 *
 */
public interface VehicleContainer
{
	public void remove(Vehicle vehicle);
	default public void registerVehicleContainer()
	{
		VehicleContainers.registerContainer(this);
	}
}
