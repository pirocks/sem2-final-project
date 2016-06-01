package ui.view;

import engine.buildings.Building;
import engine.buildings.workplaces.ToolBuilder;
import engine.cities.City;
import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;

import java.util.HashMap;

/**
 * Created by bob on 5/31/2016.
 */
public class CityAccordion {
	private City city;
	private Accordion accordion;
	private HashMap<ToolBuilder,TitledPane> factoryPanes;

	public void initVars(City city,Accordion accordion){
		this.city = city;
		this.accordion = accordion;
		factoryPanes = new HashMap<>();
	}

	public void init() {
		accordion.getPanes().clear();
		for(Building b:city.getBuilding())
		{
			VBox pane = b.getPane();
			TitledPane titledPane = new TitledPane(b.name,pane);
			if(b instanceof ToolBuilder)
				factoryPanes.put((ToolBuilder)b,titledPane);
			accordion.getPanes().add(titledPane);
		}
	}
	public void redraw(ToolBuilder toolBuilder){
		factoryPanes.get(toolBuilder).setContent(((Building)toolBuilder).getPane());
	}

}
