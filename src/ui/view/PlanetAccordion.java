package ui.view;

import engine.cities.City;
import engine.planets.Planet;
import engine.tools.vehicles.CityBuilder;
import engine.tools.vehicles.Vehicle;
import engine.universe.Country;
import javafx.event.EventHandler;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import ui.view.city.CityButton;

/**
 * Created by bob on 5/31/2016.
 */
public class PlanetAccordion extends Accordion
{
	private Planet planet;
	private Country playersCountry;
	private Controller controller;

	public void initVars(Planet planet, Country playersCountry,Controller  controller) {
		this.planet = planet;
		this.playersCountry = playersCountry;
		this.controller = controller;
	}

	public void init(){
		super.getPanes().clear();
		addCitys();
		addVehicles();
	}

	private void addVehicles() {
		for(Vehicle v: planet.getAllVehicles()) {
			VBox pane = new VBox();
			pane.getChildren().add(new Text("Vehicle:" + v.getClass().getSimpleName()));
			if(v instanceof CityBuilder) {
				Button button = new Button("Build City"){{
					setOnMouseClicked(new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent event) {
							((CityBuilder)v).buildCity();
						}
					});
				}};
				pane.getChildren().add(button);
			}
			pane.getChildren().add(new Text("Going Towards:"));
			if(v.getDestination() != null)
				pane.getChildren().add(new Text(v.getDestination().toString()));
			else
				pane.getChildren().add(new Text("None"));
			super.getPanes().add(new TitledPane(v.getClass().getName(),pane));
		}
	}

	private void addCitys() {
		for(City c: planet.getAllCities())
		{
			VBox pane = new VBox();
			TitledPane titledPane;
			if(c.getParentCountry() == playersCountry)
			{
				pane.getChildren().add(new Text(c.toString()));
				Button button = new CityButton(c,"Go To City",controller);
				pane.getChildren().add(button);
				titledPane = new TitledPane(c.name, pane);
				super.getPanes().add(0,titledPane);
			}
			else
			{
				pane.getChildren().add(new Text(c.toString()));
				pane.getChildren().add(new Text("YOU DO NOT CONTROL THIS CITY"));
				Button button = new CityButton(c,"Go To City",controller);
				pane.getChildren().add(button);
				titledPane = new TitledPane(c.name, pane);
				super.getPanes().add(titledPane);
			}
		}
	}

}
