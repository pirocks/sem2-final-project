package engine.buildings.workplaces;

import engine.cities.CityBlock;
import engine.people.cityworkers.CityWorker;
import engine.people.cityworkers.ManualWorker;
import engine.planets.LocationPlanet;
import engine.tools.AttackableConstants;
import engine.universe.MoneySource;
import engine.universe.Resource;
import engine.universe.ResourceDemand;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Warehouse extends Workplace
{
	public static double resistanceInitial = 500;
	public static double healthInitial = 20000;
	//stores weighable object
	//resource or tool
	public static int maxWorkersInitial = 1000;
	public Resource inStock;

	public Warehouse(CityBlock parentBlock, MoneySource owner) {
		super(new AttackableConstants(healthInitial,resistanceInitial,parentBlock.getLocation()),parentBlock, maxWorkersInitial, owner);
		inStock = new Resource(Resource.Type.Food,0);
	}

	@Override
	protected String getName() {
		return "WareHouse";
	}

	@Override
	public ResourceDemand getResourceCost() {
		return null;// TODO: 4/9/2016
	}

	public void addInStock(Resource resource) {
		inStock.add(resource);
	}

	@Override
	protected boolean isSuitableType(CityWorker cityWorker) {
		return cityWorker instanceof ManualWorker;
	}

	@Override
	public void addSpecific(VBox in) {
		in.getChildren().add(new Text("Resources in Stock:"));
		in.getChildren().addAll(inStock.toVbox());
	}

	@Override
	public CityWorker createCorrectType() {
		return new ManualWorker(getParentCity(),new LocationPlanet(this));
	}
}