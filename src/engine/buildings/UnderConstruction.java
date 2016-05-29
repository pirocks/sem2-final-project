package engine.buildings;

import engine.buildings.workplaces.Workplace;
import engine.cities.City;
import engine.cities.CityBlock;
import engine.people.cityworkers.CityWorker;
import engine.people.cityworkers.ManualWorker;
import engine.planets.LocationPlanet;
import engine.tools.AttackableConstants;
import engine.universe.Resource;
import engine.universe.ResourceDemand;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.Serializable;

public class UnderConstruction<Type extends Building> extends Workplace implements Serializable
{
	public static int maxWorkersInitial = 2000;
	private double timeRemaining = 10000;
	private City city;
	private Type type;
	private ResourceDemand resourceDemand;
	public UnderConstruction(LocationPlanet locationPlanet,Type building,City city) {
		super(new AttackableConstants(0,0,locationPlanet),
				new CityBlock(city,locationPlanet.getBlockx(),locationPlanet.getBlocky()),maxWorkersInitial,city.getMoneySource());//thats one massive super constructor
		this.city = city;
		type = building;
		resourceDemand = building.getResourceCost();
	}
	public boolean areWeDoneYet() {
		if(resourceDemand.fullFilledQ() && timeRemaining <= 0) {
			weDoneHandler();
			return true;
		}
		return false;
	}
	public void makeProgress(Resource resource) {
		resourceDemand.pay(resource);
		areWeDoneYet();
	}
	public void makeProgress(double time){
		timeRemaining -= time;
		areWeDoneYet();
	}
	public void weDoneHandler() {
		city.setBuilding(type);
		// TODO: 5/29/2016
	}
	@Override
	protected String getName() {
		return "Construction Site";
	}
	@Override
	public ResourceDemand getResourceCost() {
		return new ResourceDemand();
	}
	@Override
	protected boolean isSuitableType(CityWorker cityWorker) {
		return cityWorker instanceof ManualWorker;
	}
	@Override
	public VBox getPane() {
		VBox out = new VBox();
		out.getChildren().add(new Text("unconstructed"));
		out.getChildren().add(new Text(type.getName()));
		return out;
	}
	@Override
	public void addSpecific(VBox in) {

	}
	@Override
	public CityWorker createCorrectType() {
		return new ManualWorker(city,new LocationPlanet(this));
	}
	public Type getBuilding() {
		return type;
	}
}