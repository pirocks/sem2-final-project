package ui.view;

import engine.planets.Planet;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;


/**
 * Created by bob on 5/15/2016.
 */
class PlanetButton extends Button {
	Planet planet;
	Controller controller;
	public PlanetButton(Planet planet, String s,Controller controller) {
		super(s);
		this.planet = planet;
		this.controller = controller;
		super.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				controller.switchTo(planet);
			}
		});
	}
}