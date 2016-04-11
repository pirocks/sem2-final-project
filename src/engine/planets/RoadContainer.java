package engine.planets;

/**
 * Created by bob on 4/6/2016.
 *
 */
public interface RoadContainer
{
	void remove(Road road);
	default void register()
	{
		RoadContainers.registerContainer(this);
	}
}
