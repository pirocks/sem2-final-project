package engine.planets;

import java.util.ArrayList;

/**
 * Created by bob on 4/6/2016.
 *
 */
public interface RoadContainer
{
	// TODO: 5/24/2016
	void remove(Road road);
	default void register()
	{
		registerContainer(this);
	}
	ArrayList<RoadContainer> containers = new ArrayList<>();
	static void registerContainer(RoadContainer c){containers.add(c);}
	static void killRoad(Road road)
	{
		for(RoadContainer roadContainer:containers)
		{
			containers.remove(road);
		}
	}
}
