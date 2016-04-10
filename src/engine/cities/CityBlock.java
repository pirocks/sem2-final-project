package engine.cities;

import engine.buildings.Building;
import engine.buildings.BuildingContainer;
import engine.buildings.BuildingContainers;
import engine.planets.Grid;
import engine.planets.LocationPlanet;
import engine.tools.weapons.Attackable;
import engine.tools.weapons.Weapon;

public class CityBlock implements Attackable,CityContainer, BuildingContainer
{
    public int x,y;//between 0-100 inclusive??
    public LocationPlanet location;
    private Building building;
    private City parentCity;
    private Grid parentGrid;
    public CityBlock(Grid parentGrid,Building building,City parentCity,int x,int y)
    {
	    registerCityContainer();
	    registerBuildingContainer();
        this.parentGrid = parentGrid;
        this.building = building;
        this.parentCity = parentCity;
        if(parentGrid.cityBlockLocationExists(x,y))
            throw new IllegalArgumentException();
        this.x = x;
        this.y = y;
    }
    public City getParentCity()
    {
        return parentCity;
    }
    public Building getBuilding()
    {
        return building;
    }
    public LocationPlanet getLocation()
    {
        return new LocationPlanet(this);
    }
    public Grid getGrid()
    {
        return parentGrid;
    }
    public int getXInGrid()
    {
        return x;
    }
    public int getYInGrid()
    {
        return y;
    }
    @Override
    public void receiveDamage(double damage, Weapon attacker) {
        if(building !=  null)
            building.receiveDamage(damage,attacker);
    }
	@Override
	public void die() {
		building.die();
	}
	@Override
	public LocationPlanet getLocationPlanet() {
		return building.getLocationPlanet();
	}
	@Override
    public void remove(Building building) {
		if(this.building == building)
		{
			BuildingContainers.remove(building);
			this.building = null;
		}
    }
    @Override
    public void remove(City city) {
		if(parentCity == city) {
			parentCity = null;
            die();
//			assert (false);//TODO, if a city is destroyed so is everything below it right. yep, because it eliminates the citiless problem, so if a city is destryed so is everytthing eslse, will start implementing that
		}
    }
}