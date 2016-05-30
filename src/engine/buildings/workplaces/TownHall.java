package engine.buildings.workplaces;

import engine.cities.City;
import engine.cities.CityBlock;
import engine.people.cityworkers.Bureaucrat;
import engine.people.cityworkers.CityWorker;
import engine.people.cityworkers.Ruler;
import engine.planets.LocationPlanet;
import engine.tools.AttackableConstants;
import engine.tools.weapons.Attackable;
import engine.universe.MoneySource;
import engine.universe.ResourceDemand;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class TownHall extends Workplace
{
	public static double healthInitial = 10000;
	public static double resistanceInitial = 1500;
	private City parentCity;//money for city
	public static int maxWorkersInitial = 10;
	public TownHall( CityBlock parentBlock, MoneySource owner) {
		super(new AttackableConstants(parentBlock.getLocation(),healthInitial,resistanceInitial), parentBlock, maxWorkersInitial, owner);
		parentCity = parentBlock.getParentCity();
	}

	@Override
	protected String getName() {
		return "TownHall";
	}

	@Override
	public ResourceDemand getResourceCost() {
		return null;// TODO: 4/9/2016
	}

	@Override
	protected boolean isSuitableType(CityWorker cityWorker) {
		return cityWorker instanceof Ruler || cityWorker instanceof Bureaucrat;
	}

	@Override
	public void addSpecific(VBox in) {
		in.getChildren().add(new Text("TownHall for:" + parentCity.name));
		in.getChildren().add(new Text("Money avaliable" + parentCity.getMoneySource().getWealth()));
	}

	@Override
	public CityWorker createCorrectType() {
		return new Bureaucrat(parentCity,new LocationPlanet(this));
	}

	private void remove(City city) {// TODO: 5/30/2016 make these all private
		if(parentCity == city)
			parentCity = null;
		if(!amIDead)
			die();
	}

	@Override
	public void remove(Attackable attackable) {
		super.remove(attackable);
		if(attackable instanceof City){
			remove((City)attackable);
		}
	}
}