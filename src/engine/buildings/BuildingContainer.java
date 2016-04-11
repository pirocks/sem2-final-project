package engine.buildings;

/**
 * Created by bob on 4/4/2016.
 *
 */
public interface BuildingContainer
{
	void remove(Building building);
	default void registerBuildingContainer()
	{
		BuildingContainers.registerContainer(this);
	}
}
