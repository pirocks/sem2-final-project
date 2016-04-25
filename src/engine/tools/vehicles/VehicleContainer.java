package engine.tools.vehicles;

import java.util.ArrayList;

/**
 * Created by bob on 4/4/2016.
 *
 */
public interface VehicleContainer
{
	void remove(Vehicle vehicle);
	default void registerVehicleContainer()
	{
		registerContainer(this);
	}
	static ArrayList<VehicleContainer> containers= new ArrayList<>();
	public static void registerContainer(VehicleContainer vehicleContainer)
	{
		containers.add(vehicleContainer);
	}
	public static void killVehicle(Vehicle in)
	{
		for(VehicleContainer container :containers)
		{
			container.remove(in);
		}
	}
}
