package ui.view;

import engine.buildings.Building;
import engine.buildings.workplaces.ToolBuilder;
import engine.cities.City;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bob on 5/31/2016.
 */
public class CityAccordion {
	private City city;
	private Accordion accordion;
	private HashMap<ToolBuilder,TitledPane> factoryPanes;
	private int inFocus;

	public void initVars(City city,Accordion accordion) {
		this.city = city;
		this.accordion = accordion;
		factoryPanes = new HashMap<>();
		inFocus = 0;
		accordion.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						inFocus = accordion.getPanes().indexOf(accordion.getExpandedPane());
					}
				});
			}
		});
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
		accordion.setExpandedPane(accordion.getPanes().get(inFocus));
	}
	public void redraw(ToolBuilder toolBuilder){
		factoryPanes.get(toolBuilder).setContent(((Building)toolBuilder).getPane());
	}
	private void redrawFactoryTime(ToolBuilder toolBuilder){
		VBox content = (VBox) factoryPanes.get(toolBuilder).getContent();
		for (Node node : content.getChildren()) {
			if(node instanceof Text)
				if(((Text)node).getText().contains("Time  Remaining"))
					((Text)node).setText("Time Remaining" + toolBuilder.getTimeRemaining());
		}

	}
	public void liverUpdate(){
		for (Map.Entry<ToolBuilder, TitledPane> toolBuilderTitledPaneEntry : factoryPanes.entrySet()) {
			for (TitledPane titledPane : accordion.getPanes()) {
				if(toolBuilderTitledPaneEntry.getValue() == titledPane)
					redrawFactoryTime(toolBuilderTitledPaneEntry.getKey());
			}

		}

	}
	public void updateResearchAreas() {
		init();
	}
}
