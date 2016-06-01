package ui.view;

import engine.universe.Country;
import engine.universe.SolarSystem;
import engine.universe.Universe;
import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import ui.view.solarsystem.SolarSystemButton;



/**
 * Created by bob on 5/31/2016.
 */
public class UniverseAccordion {
	private Universe universe;
	private Country playersCountry;
	private Controller controller;
	private Accordion universeAccordion;

	public void init(){
		universeAccordion.getPanes().clear();
		for(SolarSystem solarSystem:universe.getSolarSystems())
		{
			VBox pane = new VBox();
			pane.getChildren().add(new Text(solarSystem.name));
			pane.getChildren().add(new SolarSystemButton(solarSystem,solarSystem.name,playersCountry, controller));
			universeAccordion.getPanes().add(new TitledPane(solarSystem.name,pane));
		}
	}
	public void initVars(Universe universe, Country playersCountry, Controller controller, Accordion universeAccordion){

		this.universe = universe;
		this.playersCountry = playersCountry;
		this.controller = controller;
		this.universeAccordion = universeAccordion;
	}
}
