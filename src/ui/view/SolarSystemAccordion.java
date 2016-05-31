package ui.view;

import engine.planets.Planet;
import engine.universe.SolarSystem;
import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import ui.view.planet.PlanetButton;

/**
 * Created by bob on 5/31/2016.
 */
public class SolarSystemAccordion extends Accordion{
	private SolarSystem solarSystem;
	private Controller controller;

	public void initVars(SolarSystem solarSystem,Controller controller){
		this.solarSystem = solarSystem;
		this.controller = controller;
	}
	public void init(){
		super.getPanes().clear();
		for(Planet planet:solarSystem.getPlanets())
		{
			VBox pane = new VBox();
			pane.getChildren().add(new Text(planet.name));
			pane.getChildren().add(new PlanetButton(planet,"Go To Planet",controller));
			super.getPanes().add(new TitledPane(planet.name,pane));
		}
	}
}
