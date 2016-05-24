package engine.buildings;

import engine.cities.City;
import engine.cities.CityBlock;
import engine.people.AbstractPerson;
import engine.planets.LocationPlanet;
import engine.tools.AttackableConstants;
import engine.universe.Resource;
import engine.universe.ResourceDemand;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.Serializable;

public class UnderConstruction<Type extends Building> extends Building implements Serializable
{
	private City city;

	private Type type;

	private ResourceDemand resourceDemand;

	public UnderConstruction(LocationPlanet locationPlanet,Type building,City city)
	{
		super(new AttackableConstants(0,0,locationPlanet),
				new CityBlock(new AttackableConstants(0,0,locationPlanet),locationPlanet.getGrid(),null,city,
						locationPlanet.getBlockx(),locationPlanet.getBlocky()));//thats one massive super constructor
		this.city = city;
		type = building;
		resourceDemand = building.getResourceCost();
	}

	public boolean areWeDoneYet()
	{
		if(resourceDemand.fullFilledQ()) {
			weDoneHandler();
			return true;
		}
		return false;
	}

	public void makeProgress(Resource resource)
	{
		resourceDemand.pay(resource);
	}

	public void weDoneHandler()
	{
		city.setBuilding(type);
	}

	@Override
	protected String getName() {
		return "Construction Site";
	}

	@Override
	public void remove(AbstractPerson person) {
		return;
	}

	@Override
	public ResourceDemand getResourceCost() {
		return new ResourceDemand();
	}

	@Override
	public VBox getPane() {
		VBox out = new VBox();
		out.getChildren().add(new Text("unconstructed"));
		out.getChildren().add(new Text(type.getName()));
		return out;
	}

	public Type getBuilding() {
		return type;
	}
}