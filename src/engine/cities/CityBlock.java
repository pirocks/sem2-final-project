package engine.cities;

import engine.buildings.Building;
import engine.planets.Grid;
import engine.planets.LocationPlanet;
import engine.tools.AttackableConstants;
import engine.tools.weapons.Attackable;
import engine.tools.weapons.Weapon;

import java.io.Serializable;
import java.util.ArrayList;

//import engine.buildings.BuildingContainers;

public class CityBlock extends Attackable implements Serializable, Container
{
    public int x,y;//between 0-100 inclusive??

	private Building building;

	private City parentCity;
	private Grid parentGrid;
	public CityBlock(AttackableConstants attackableConstants,Grid parentGrid, Building building, City parentCity, int x, int y) {
	    super(attackableConstants);
        this.parentGrid = parentGrid;
        this.building = building;
        this.parentCity = parentCity;
        this.x = x;
        this.y = y;
		registerContainer(parentCity);
    }
	public City getParentCity()
    {
        return parentCity;
    }
	public Building getBuilding()
    {
        return building;
    }
	public ArrayList<LocationPlanet> getLocation() {
        ArrayList<LocationPlanet> out = new ArrayList<LocationPlanet>();
	    out.add(new LocationPlanet(this));
	    return out;
    }
	@Override
	public void die() {
		if(!amIDead) {
			super.die();
			building.die();
		}
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
	public void setBuilding(Building building) {
		if(this.building != null) {
			deregisterContainer(this.building);
			building.die();
		}
		this.building = building;
		registerContainer(building);
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
	public void remove(City city) {
		if(parentCity == city) {
			parentCity = null;
			die();
		}
	}
	public void remove(Building building) {
		if(this.building == building)
		{
			this.building = null;
		}
	}
	@Override
	public boolean receiveDamage(double damage, Weapon attacker) {
		return building.receiveDamage(damage, attacker);
	}
	@Override
	public void remove(Attackable attackable) {
		if(attackable instanceof Building) {
			remove((Building) attackable);
		}
		else if(attackable instanceof City){
			remove((City)attackable);
		}
		else
			throw new IllegalStateException();
	}
}