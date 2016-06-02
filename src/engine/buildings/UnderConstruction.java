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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import ui.view.Controller;

import java.io.Serializable;
import java.util.Optional;

public class UnderConstruction<Type extends Building> extends Workplace implements Serializable,ResourceUser
{
	public static int maxWorkersInitial = 2000;
	private double timeRemaining = 10000;
	private City city;
	private Type type;
	private ResourceDemand resourceDemand;
	public UnderConstruction(LocationPlanet locationPlanet,Type building,City city) {
		super(new AttackableConstants(1,1,locationPlanet),
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
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("A " +  type.getClass().getSimpleName() + " has been finished");
		alert.getButtonTypes().add(new ButtonType("Ok"));
		alert.getButtonTypes().add(new ButtonType("Take me to The City"));
		Optional<ButtonType> buttonType = alert.showAndWait();
		String result =  "Ok";
		if(buttonType.isPresent()){
			result = buttonType.get().getText();
		}
		if(result.equals("Ok")){
			city.setBuilding(type);

		}else{
			city.setBuilding(type);
			goToBuilding();
		}
	}
	private void goToBuilding(){
		Controller.controller.switchTo(this.getParentBlock());
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
	public void addSpecific(VBox in) {
		in.getChildren().add(new Text(type.getName() + "Under Construction"));
		in.getChildren().add(new Text("Man hours remaining:" + timeRemaining));
		in.getChildren().add(new Text("Resources still required" + resourceDemand.toString()));
		addAddResourcesButton(in);
	}
	@Override
	public CityWorker createCorrectType() {
		return new ManualWorker(city,new LocationPlanet(this));
	}
	public Type getBuilding() {
		return type;
	}

	@Override
	public City getCity() {
		return getParentCity();
	}
}