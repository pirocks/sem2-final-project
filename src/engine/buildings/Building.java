package engine.buildings;

import engine.buildings.housing.ApartmentBlock;
import engine.buildings.housing.RulersHouse;
import engine.buildings.housing.WorkersHouseBlock;
import engine.buildings.workplaces.*;
import engine.cities.City;
import engine.cities.CityBlock;
import engine.cities.CityContainer;
import engine.people.AbstractPerson;
import engine.people.PersonContainer;
import engine.planets.LocationPlanet;
import engine.tools.weapons.Attackable;
import engine.tools.weapons.Weapon;
import engine.universe.ResourceDemand;

/**
 * Created by bob on 3/5/2016.
 * does stuuff
 */
public abstract class Building implements Attackable, CityContainer, PersonContainer//extends moneysource for workplace maybe??
{
    private double health = 1.0;//form 0 to infinity
    private double resistance;//the resistance as a 0 to 1.0 percentage
	// protected double costToBuild;//irrelevant
    // private double costToMaintain;//maybe get rid off or leave for later//leaving for later
    @Deprecated public static enum Type
    {
        ApartmentBlock,Factory,Hospital,IndustrialDock,ResearchArea,RulersHouse,School,TownHall,Warehouse,WorkersHouseBlock;
    }
	private final boolean workplaceQ;
	private final boolean housingQ;
	protected CityBlock parentBlock;
//	protected final Type type;//not necessary but whatever
	public Building(CityBlock parentBlock,boolean housingQ)
    {
	    registerCityContainer();
	    registerPersonContainer();//TODO:go through and make sure every constructor has these
//        this.type = type;
        if(housingQ)
        {
            this.workplaceQ = false;
            this.housingQ = true;
        }
        else
        {
            this.workplaceQ = true;
            this.housingQ = false;
        }
        this.parentBlock = parentBlock;
        if(this instanceof ApartmentBlock) {
		    resistance = ApartmentBlock.resistanceInitial;
	    }
	    if(this instanceof Factory) {
		    resistance = Factory.resistanceInitial;
	    }
	    if(this instanceof Hospital) {
		    resistance = Hospital.resistanceInitial;
	    }
	    if(this instanceof IndustrialDock) {
		    resistance = IndustrialDock.resistanceInitial;
	    }
	    if(this instanceof ResearchArea) {
		    resistance = ResearchArea.resistanceInitial;
	    }
	    if(this instanceof RulersHouse) {
		    resistance = RulersHouse.resistanceInitial;
	    }
	    if(this instanceof School) {
		    resistance = School.resistanceInitial;
	    }
	    if(this instanceof TownHall) {
		    resistance = TownHall.resistanceInitial;
	    }
	    if(this instanceof Warehouse) {
		    resistance = Warehouse.resistanceInitial;
	    }
        if(this instanceof WorkersHouseBlock) {
                resistance = WorkersHouseBlock.resistanceInitial;
        }
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
//	public Type getType() {
//        return type;
//    }
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

	public abstract ResourceDemand getResourceCost();
	public abstract double getCost();

}
