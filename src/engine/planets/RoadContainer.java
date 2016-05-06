package engine.planets;

import java.util.ArrayList;

/**
 * Created by bob on 4/6/2016.
 *
 */
public interface RoadContainer
{
	void remove(Road road);
	default void register()
	{
		registerContainer(this);
	}
	static ArrayList<RoadContainer> containers = new ArrayList<>();
	public static void registerContainer(RoadContainer c){containers.add(c);}
	public static void killRoad(Road road)
	{
		for(RoadContainer roadContainer:containers)
		{
			containers.remove(road);
		}
	}
}
