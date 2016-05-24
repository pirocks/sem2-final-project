package engine.planets;

import java.util.ArrayList;

/**
 * Created by bob on 4/5/2016.
 *
 */
public interface PlanetContainer
{
	void remove(Planet planet);
	default void registerPlanetContainer() {
		registerContainer(this);
	}
	ArrayList<PlanetContainer> containers = new ArrayList<PlanetContainer>();
	static void registerContainer(PlanetContainer in) {
		containers.add(in);
	}
	static void killPlanet(Planet in)
	{
		for(PlanetContainer container:containers)
		{
			container.remove(in);
		}
	}
}
