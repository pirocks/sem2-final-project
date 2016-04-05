package planets;

/**
 * Created by bob on 4/5/2016.
 *
 */
public interface PlanetContainer
{
	public void remove(Planet planet);
	default public void register()
	{
		PlanetContainers.registerContainer(this);
	}
}
