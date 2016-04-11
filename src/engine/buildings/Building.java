package engine.buildings;

import engine.buildings.housing.Housing;
import engine.buildings.workplaces.*;
import engine.cities.City;
import engine.cities.CityBlock;
import engine.cities.CityContainer;
import engine.people.AbstractPerson;
import engine.people.PersonContainer;
import engine.planets.LocationPlanet;
import engine.tools.AttackableConstants;
import engine.tools.weapons.Attackable;
import engine.universe.ResourceDemand;

/**
 * Created by bob on 3/5/2016.
 * does stuff
 */
public abstract class Building implements Attackable,CityContainer, PersonContainer//extends moneysource for workplace maybe??
{
	protected CityBlock parentBlock;
	private AttackableConstants attackableConstants;
	public Building(AttackableConstants attackableConstants,
	                CityBlock parentBlock) {
	    this.attackableConstants = attackableConstants;
	    registerCityContainer();
	    registerPersonContainer();//TODO:go through and make sure every constructor has these
        this.parentBlock = parentBlock;

    }
	public City getParentCity()
    {
        return parentBlock.getParentCity();
    }
	public CityBlock getParentBlock()
    {
        return parentBlock;
    }
	public LocationPlanet getLocation()
    {
        return parentBlock.getLocation();
    }
	@Override
	public boolean receiveDamage(double damage) {
		return attackableConstants.receiveDamage(damage, this);// TODO: 4/10/2016 this can be done better, the this can be avoided, can return a boolean for attack succsess.
	}
	@Override
	public void die() {
		BuildingContainers.remove(this);
	}
	@Override
	public LocationPlanet getLocationPlanet() {
		return new LocationPlanet(this);
	}
	@Override
	public abstract void remove(AbstractPerson person);
	@Override
	public void remove(City city) {
		die();
		parentBlock.remove(city);// TODO: 4/9/2016 check that this desn't cause infinte recursion
	}
	public boolean HousingQ() {
		return this instanceof Housing;
	}
	public boolean WorkplaceQ(){
		return this instanceof Workplace;
	}
	public abstract ResourceDemand getResourceCost();
//	public abstract double getCost();
}
