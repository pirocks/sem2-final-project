package engine.tools.vehicles;

import java.util.ArrayList;

/**
 * Created by bob on 4/4/2016.
 *
 */
public interface VehicleContainer
{
	// TODO: 5/24/2016
	void remove(Vehicle vehicle);
	default void registerVehicleContainer()
	{
		registerContainer(this);
	}
	ArrayList<VehicleContainer> containers= new ArrayList<>();
	static void registerContainer(VehicleContainer vehicleContainer)
	{
		containers.add(vehicleContainer);
	}
	static void killVehicle(Vehicle in)
	{
		for(VehicleContainer container :containers)
		{
			container.remove(in);
		}
	}
}
