package engine.planets;

/**
 * Created by bob on 4/6/2016.
 *
 */
public interface RoadContainer
{
	public void remove(Road road);
	default public void register()
	{
		RoadContainers.registerContainer(this);
	}
}
