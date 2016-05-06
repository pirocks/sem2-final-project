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

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by bob on 3/5/2016.
 * does stuff
 */
public abstract class Building extends Attackable implements Serializable,CityContainer, PersonContainer//extends moneysource for workplace maybe??
{
	protected CityBlock parentBlock;
//	private AttackableConstants attackableConstants;
	public Building(AttackableConstants attackableConstants,
	                CityBlock parentBlock) {
	    super(attackableConstants);
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
	@Override
	public void die() {
		BuildingContainer.killBuilding(this);
	}
//	@Override
//	public ArrayList<LocationPlanet> getLocationPlanet() {
//		return new LocationPlanet(this);
//	}
	@Override
	public abstract void remove(AbstractPerson person);
	@Override
	public void remove(City city) {
		die();
		parentBlock.remove(city);// oldTODO: 4/9/2016 check that this desn't cause infinte recursion//it doesn't
	}
	public boolean HousingQ() {
		return this instanceof Housing;
	}
	public boolean WorkplaceQ(){
		return this instanceof Workplace;
	}
	public abstract ResourceDemand getResourceCost();
}
