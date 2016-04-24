package engine.buildings;

import engine.universe.Country;
import engine.universe.CountryContainer;

import java.util.ArrayList;

/**
 * Created by bob on 4/4/2016.
 *
 */
public interface BuildingContainer
{
	void remove(Building building);
	default void registerBuildingContainer()
	{
		registerContainer(this);
	}
	static ArrayList<BuildingContainer> containers = new ArrayList<>();
	static void registerContainer(BuildingContainer in)
	{
		containers.add(in);
	}
	static void killBuilding(Building toRemove)
	{
		for(BuildingContainer container :containers)
		{
			container.remove(toRemove);
		}
	}
}
