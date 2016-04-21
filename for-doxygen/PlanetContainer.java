package engine.planets;

/**
 * Created by bob on 4/5/2016.
 *
 */
public interface PlanetContainer
{
	void remove(Planet planet);
	default void registerPlanetContainer()
	{
		PlanetContainers.registerContainer(this);
	}
}
