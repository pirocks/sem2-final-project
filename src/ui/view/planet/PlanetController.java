package ui.view.planet;

import engine.cities.City;
import engine.planets.Planet;
import engine.universe.Country;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import ui.view.city.CityThread;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by bob on 5/7/2016.
 *
 */
public class PlanetController implements Initializable {
	@FXML
	Accordion accordion;
	@FXML
	MenuItem about;
	@FXML
	MenuItem close;
	@FXML
	BorderPane borderPane;
	@FXML
	public void onClose()
	{
		System.exit(0);
	}

	private Planet planet;
	private Country playersCountry;

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

	public void updateVars(Planet planet,Country playersCountry)
	{
		this.planet = planet;
		this.playersCountry =  playersCountry;
	}


	public void updateAccordion() {
		System.out.print("cities:" + planet.getAllCities());
		for(City c: planet.getAllCities())
		{
			VBox pane = new VBox();
			if(c.getParentCountry() == playersCountry)
			{
				pane.getChildren().add(new Text(c.toString()));
				Button button = new CityButton(c,"Go To City");
				pane.getChildren().add(button);
			}
			else
			{
				pane.getChildren().add(new Text(c.toString()));
				pane.getChildren().add(new Text("YOU DO NOT CONTROL THIS CITY"));
				Button button = new CityButton(c,"Go To City");
				pane.getChildren().add(button);
			}
			accordion.getPanes().add(new TitledPane(c.name,pane));
		}
	}

	public void updateTabs()
	{

	}

	private class CityButton extends Button {
		private City city;

		public CityButton(City c, String s) {
			super(s);
			city = c;
			super.setOnAction(new EventHandler<ActionEvent>() {
                  @Override
                  public void handle(ActionEvent event) {
	                  new CityThread(city, playersCountry).run();
                  }
              });
		}
	}
}
