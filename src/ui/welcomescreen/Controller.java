package ui.welcomescreen;

import engine.universe.UniversalConstants;
import engine.universe.UniverseConstructionContext;
import engine.universe.UniverseGenerator;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class Controller implements Initializable {

	public static boolean areWeGoForLaunchQ;

	@FXML
	TextField enemyGovernmentStartWealth;
	@FXML
	MenuButton enemyGovernmentType;
	@FXML
	TextField startWealth;
	@FXML
	MenuButton governmentType;
	@FXML
	TextField numSolarSystem;
	@FXML
	TextField numPlanetsPerSolarSystem;
	@FXML
	TextField universeSize;
	@FXML
	TextField numHazards;
	@FXML
	TextField numCountries;
	@FXML
	TextField peoplePerCity;

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
		numSolarSystem.setText("15");
		universeSize.setText(""+Double.MAX_VALUE);
		numCountries.setText("5");
		numPlanetsPerSolarSystem.setText("5");
		peoplePerCity.setText("10000");
		numHazards.setText("0");
	}
	@FXML public void generateClicked()
	{
		boolean invalidQ = false;
		int solarSystemCount = 15;
		try
		{
			solarSystemCount = Integer.parseInt(numSolarSystem.getText());
		}
		catch (NumberFormatException e)
		{
			invalidQ = true;
		}
		Double universeRadius = Double.MAX_VALUE;
		try
		{
			universeRadius = Double.valueOf((universeSize.getText()));
		}
		catch (Exception e)
		{
			invalidQ = true;
		}
		int numCountries = 5;
		try
		{
			numCountries = Integer.parseInt(this.numCountries.getText());
		}
		catch (Exception e)
		{
			invalidQ = true;
		}
		int numPlanets = 5;
		try
		{
			numPlanets = solarSystemCount*Integer.parseInt(numPlanetsPerSolarSystem.getText());
		}
		catch(Exception e)
		{
			invalidQ = true;
		}
		UniversalConstants.peoplePerCity = 10000;
		try {
			UniversalConstants.peoplePerCity = Integer.parseInt(peoplePerCity.getText());
		} catch (NumberFormatException e)
		{
			invalidQ = true;
		}
		int numHazards = 0;
		try {
			numHazards = Integer.parseInt(this.numHazards.getText());
		} catch (NumberFormatException e)
		{
			invalidQ = true;
		}
		double industryProb = 0.9;// TODO: 5/20/2016
		UniverseConstructionContext universeConstructionContext = new UniverseConstructionContext(
				solarSystemCount, universeRadius,
				numCountries, numPlanets, numHazards,
				industryProb);
		areWeGoForLaunchQ = true;
		if(invalidQ)
		{
			areWeGoForLaunchQ = false;
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("invalid.fxml"));
				Parent root = loader.load();
				InvalidController invalidController = loader.getController();
				invalidController.setConstructionContext(universeConstructionContext);
				Scene scene = new Scene(root);
				Stage stage = new Stage();
				stage.setScene(scene);
				stage.show();
			} catch (IOException e) {
				e.printStackTrace();
				throw new IllegalStateException(e);
			}
		}
		if(areWeGoForLaunchQ) {
			UniverseGenerator generator = new UniverseGenerator(universeConstructionContext);
//		Thread universeGenerationThread = new Thread(generator);
//		universeGenerationThread.run();
			generator.run();
		}
	}

}
