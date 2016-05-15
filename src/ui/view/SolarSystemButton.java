package ui.view;

import engine.universe.Country;
import engine.universe.SolarSystem;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * Created by bob on 5/14/2016.
 *
 */
public class SolarSystemButton extends Button
{
	private SolarSystem solarSystem;
	private Country playersCountry;
	private Controller controller;
	public SolarSystemButton(SolarSystem s, String string, Country playersCountry, Controller controller)
	{
		super(string);
		solarSystem = s;
		this.playersCountry = playersCountry;
		this.controller = controller;
		super.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				controller.switchTo(solarSystem);
			}
		});
	}
}