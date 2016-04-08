package engine.planets;

import java.util.ArrayList;

/**
 * Created by bob on 4/5/2016.
 *
 */
public class PlanetContainers
{
	private static ArrayList<PlanetContainer> containers = new ArrayList<PlanetContainer>();
	public static void registerContainer(PlanetContainer in)
	{
		containers.add(in);
	}
	public static void remove(Planet in)
	{
		for(PlanetContainer container:containers)
		{
			container.remove(in);
		}
	}
}
