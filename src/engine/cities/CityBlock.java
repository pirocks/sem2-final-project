package engine.cities;

import engine.buildings.Building;
import engine.buildings.BuildingContainer;
//import engine.buildings.BuildingContainers;
import engine.planets.Grid;
import engine.planets.LocationPlanet;
import engine.tools.AttackableConstants;
import engine.tools.weapons.Attackable;
import engine.tools.weapons.Weapon;

import java.io.Serializable;
import java.util.ArrayList;

public class CityBlock extends Attackable implements Serializable, CityContainer, BuildingContainer
{
    public int x,y;//between 0-100 inclusive??

	private Building building;

	private City parentCity;
	private Grid parentGrid;
	public CityBlock(AttackableConstants attackableConstants,Grid parentGrid, Building building, City parentCity, int x, int y)
    {
	    super(attackableConstants);
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
	public ArrayList<LocationPlanet> getLocation()
    {
        ArrayList<LocationPlanet> out = new ArrayList<LocationPlanet>();
	    out.add(new LocationPlanet(this));
	    return out;
    }
	@Override
	public void die() {
		BuildingContainer.killBuilding(building);
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
    public void remove(City city) {
		if(parentCity == city) {
			parentCity = null;
            die();
		}
    }
	//	public void die() {
//		building.die();
//	}
//	@Override
//	public LocationPlanet getLocationPlanet() {
//		return building.getLocationPlanet();
//	}
	public void setBuilding(Building building) {
		this.building = building;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Grid getParentGrid() {
		return parentGrid;
	}
	//	@Override
	@Override
	public void remove(Building building) {
		if(this.building == building)
		{
			BuildingContainer.killBuilding(building);//todo is this consistent with other classes?
			this.building = null;
		}
	}

	@Override
	public boolean receiveDamage(double damage, Weapon attacker) {
		return building.receiveDamage(damage, attacker);
	}
}