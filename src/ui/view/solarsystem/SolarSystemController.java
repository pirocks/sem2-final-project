package ui.view.solarsystem;

import engine.planets.Planet;
import engine.universe.SolarSystem;
import javafx.embed.swing.SwingNode;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import ui.view.planet.PlanetThread;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by bob on 5/9/2016.
 *
 */
public class SolarSystemController implements Initializable {

	private SolarSystem solarSystem;
	@FXML
	Accordion accordion;
	@FXML
	SwingNode swingNode;

	/**
	 * Called to initialize a controller after its root element has been
	 * completely processed.
	 *
	 * @param location  The location used to resolve relative paths for the root object, or
	 *                  <tt>null</tt> if the location is not known.
	 * @param resources The resources used to localize the root object, or <tt>null</tt> if
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
	public void updateAccordion(SolarSystem s)
	{
		solarSystem = s;
		swingNode.setContent(new SolarSystemJPanel());
//		System.out.print(solarSystem.getPlanets());
		for(Planet planet:solarSystem.getPlanets())
		{
			VBox pane = new VBox();
			pane.getChildren().add(new Text(planet.toString()));
			Button button = new PlanetButton(planet,"Go To Planet");
			pane.getChildren().add(button);
			accordion.getPanes().add(new TitledPane(planet.name,pane));
		}
	}
	@FXML
	public void onClose()
	{
		System.exit(0);//maje surre that this is actuall named exit game // TODO: 5/9/2016
	}

	private class PlanetButton extends Button {
		Planet planet;
		public PlanetButton(Planet planet, String s) {
			super(s);
			this.planet = planet;
			super.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					new PlanetThread().run();
				}
			});
		}
	}
}
