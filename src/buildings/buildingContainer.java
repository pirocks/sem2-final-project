package buildings;

/**
 * Created by bob on 4/4/2016.
 *
 */
public interface BuildingContainer
{
	public void remove(Building building);
	default public void register()
	{
		BuildingContainers.registerContainer(this);
	}
}
