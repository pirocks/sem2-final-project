package engine.planets;

/**
 * Created by bob on 4/5/2016.
 *
 */
public interface PlanetContainer
{
	// TODO: 5/24/2016
	void remove(Planet planet);
	default void registerPlanetContainer()
	{
		PlanetContainers.registerContainer(this);
	}
}
