package engine.buildings;

import engine.buildings.housing.Housing;
import engine.buildings.workplaces.Workplace;
import engine.cities.City;
import engine.cities.CityBlock;
import engine.cities.CityContainer;
import engine.people.AbstractPerson;
import engine.people.PersonContainer;
import engine.tools.AttackableConstants;
import engine.tools.weapons.Attackable;
import engine.universe.ResourceDemand;
import javafx.scene.layout.VBox;

import java.io.Serializable;

/**
 * Created by bob on 3/5/2016.
 * does stuff
 */
public abstract class Building extends Attackable implements Serializable,CityContainer, PersonContainer//extends moneysource for workplace maybe??
{
	protected CityBlock parentBlock;
	public String name;

	//	private AttackableConstants attackableConstants;
	public Building(AttackableConstants attackableConstants,
	                CityBlock parentBlock) {
	    super(attackableConstants);
	    registerCityContainer();
	    registerPersonContainer();//TODO:go through and make sure every constructor has these
        this.parentBlock = parentBlock;
		name = getName();
    }

	protected abstract String getName();

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
	public abstract ResourceDemand getResourceCost();//cost to build
	public abstract VBox getPane();
}
