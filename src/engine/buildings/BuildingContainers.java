package engine.buildings;

import java.util.ArrayList;

/**
 * Created by bob on 4/5/2016.
 *
 */
public class BuildingContainers
{
	private static ArrayList<BuildingContainer> containers = new ArrayList<>();
	public static void registerContainer(BuildingContainer b)
	{
		containers.add(b);
	}
	public static void remove(Building in)
	{
		for(BuildingContainer container :containers)
		{
			container.remove(in);
		}
	}

}
