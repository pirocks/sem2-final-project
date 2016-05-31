package ui.view;

import engine.buildings.Building;
import engine.cities.City;
import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;

/**
 * Created by bob on 5/31/2016.
 */
public class CityAccordion extends Accordion{
	private City city;
	private Accordion accordion;

	public void initVars(City city,Accordion accordion){
		this.city = city;
		this.accordion = accordion;
	}

	public void init() {
		accordion.getPanes().clear();
		for(Building b:city.getBuilding())
		{
			VBox pane = b.getPane();
			TitledPane titledPane = new TitledPane(b.name,pane);
			accordion.getPanes().add(titledPane);
		}
	}
}
