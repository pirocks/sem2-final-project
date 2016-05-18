package ui.view.planet;

import engine.planets.Planet;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import ui.view.Controller;


/**
 * Created by bob on 5/15/2016.
 */
public class PlanetButton extends Button {
	private Planet planet;
	private Controller controller;
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