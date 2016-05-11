package engine.buildings;

import engine.planets.LocationPlanet;

/**
 * Created by bob on 4/10/2016.
 *
 */

//this entire class is useless and deprecated
@Deprecated public class BuildingConstructionContext<Type extends Building>
{
	Type building;
	LocationPlanet location;
	//this construction context isn't based n the previous construction context since more finess is needed
	public BuildingConstructionContext(LocationPlanet location,Type bu)
	{
		this.location = location;
	}
	public Type getFinishedBuilding()
	{
		return building;
	}
}
