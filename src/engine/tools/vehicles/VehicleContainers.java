package engine.tools.vehicles;

import java.util.ArrayList;

/**
 * Created by bob on 4/5/2016.
 *
 */
public class VehicleContainers
{
	private static ArrayList<VehicleContainer> containers= new ArrayList<>();
	public static void registerContainer(VehicleContainer vehicleContainer)
	{
		containers.add(vehicleContainer);
	}
	public static void remove(Vehicle in)
	{
		for(VehicleContainer container :containers)
		{
			container.remove(in);
		}
	}
}
