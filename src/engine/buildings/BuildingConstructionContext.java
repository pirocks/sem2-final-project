package engine.buildings;

import engine.planets.LocationPlanet;

/**
 * Created by bob on 4/10/2016.
 *
 */
public class BuildingConstructionContext<Type extends Building>
{
	LocationPlanet location;
	//this construction context isn't based n the previous construction context since more finess is needed
	public BuildingConstructionContext(LocationPlanet location)
	{
		this.location = location;
	}
	public Building getFinishedBuilding()
	{

	}
}
