package engine.buildings;

import engine.buildings.housing.ApartmentBlock;
import engine.buildings.housing.Housing;
import engine.buildings.housing.RulersHouse;
import engine.buildings.housing.WorkersHouseBlock;
import engine.buildings.workplaces.*;
import engine.cities.City;
import engine.cities.CityBlock;
import engine.cities.CityContainer;
import engine.people.AbstractPerson;
import engine.people.PersonContainer;
import engine.planets.LocationPlanet;
import engine.tools.AttackableInitialConstants;
import engine.tools.weapons.Attackable;
import engine.tools.weapons.Weapon;
import engine.universe.ResourceDemand;

/**
 * Created by bob on 3/5/2016.
 * does stuff
 */
public abstract class Building extends Attackable implements CityContainer, PersonContainer//extends moneysource for workplace maybe??
{
	protected CityBlock parentBlock;
	public Building(AttackableInitialConstants attackableInitialConstants,
	                CityBlock parentBlock) {
	    super(attackableInitialConstants);
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
	public void receiveDamage(double damage, Weapon attacker)
	{
		health -= (1.0 - resistance)*damage;
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
		if (this instanceof Housing)
			return true;
		return false;
	}
	public boolean WorkplaceQ(){
		if(this instanceof Workplace)
			return true;
		return false;
	}
	public abstract ResourceDemand getResourceCost();
//	public abstract double getCost();
}
