package engine.buildings.workplaces;

import engine.cities.CityBlock;
import engine.tools.AttackableConstants;
import engine.universe.MoneySource;
import engine.universe.Resource;
import engine.universe.ResourceDemand;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Warehouse extends Workplace
{
	public static double resistanceInitial;
	public static double healthInitial;
	//stores weighable object
	//resource or tool
	public static int maxiWorkersInitial;
	public static double costInitial;
	public Resource inStock;

	public Warehouse(CityBlock parentBlock, MoneySource owner) {
		super(new AttackableConstants(healthInitial,resistanceInitial,parentBlock.getLocation()),parentBlock, maxiWorkersInitial, owner);
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
	public void addSpecific(VBox in) {
		in.getChildren().add(new Text("Resources in Stock:"));
		in.getChildren().addAll(inStock.toVbox());
	}
}