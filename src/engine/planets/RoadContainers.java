package engine.planets;

import java.util.ArrayList;

/**
 * Created by bob on 4/6/2016.
 *
 */
public class RoadContainers
{
	private static ArrayList<RoadContainer> containers = new ArrayList<>();
	public static void registerContainer(RoadContainer c){containers.add(c);}
	public static void remove(Road road)
	{
		for(RoadContainer roadContainer:containers)
		{
			containers.remove(road);
		}
	}
}
