package ui.welcomescreen;

import engine.universe.UniversalConstants;
import engine.universe.UniverseConstructionContext;
import engine.universe.UniverseGenerator;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
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
	@FXML
	CheckBox disableEnemy;
	@FXML
	CheckBox generateOneStartingCity;

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
		disableEnemy.setSelected(true);
		generateOneStartingCity.setSelected(true);
	}
	private boolean invalidQ = false;
	@FXML public void generateClicked()
	{
		invalidQ = false;
		int solarSystemCount = 15;
		solarSystemCount = getSolarSystemCount(solarSystemCount);
		Double universeRadius = Double.MAX_VALUE;
		universeRadius = getaDouble(universeRadius);
		int numCountries = 5;
		numCountries = getNumCountries(numCountries);
		int numPlanets = 5;
		numPlanets = getNumPlanets(solarSystemCount, numPlanets);
		UniversalConstants.peoplePerCity = 10000;
		getPeoplePerCity();
		int numHazards = 0;
		numHazards = getNumHazards(numHazards);
		double industryProb = 0.75;
		boolean generateOtherCountries = disableEnemy.selectedProperty().getValue();
		boolean onlyGenerateOnePlayersCountry = generateOneStartingCity.selectedProperty().getValue();
		UniverseConstructionContext universeConstructionContext = new UniverseConstructionContext(
				solarSystemCount, universeRadius,
				numCountries, numPlanets, numHazards,
				industryProb, generateOtherCountries, onlyGenerateOnePlayersCountry);
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

	public int getNumHazards(int numHazards) {
		try {
			numHazards = Integer.parseInt(this.numHazards.getText());
		} catch (NumberFormatException e)
		{
			invalidQ = true;
		}
		return numHazards;
	}

	public void getPeoplePerCity() {
		try {
			UniversalConstants.peoplePerCity = Integer.parseInt(peoplePerCity.getText());
		} catch (NumberFormatException e)
		{
			invalidQ = true;
		}
	}

	public int getNumPlanets(int solarSystemCount, int numPlanets) {
		try
		{
			numPlanets = Integer.parseInt(numPlanetsPerSolarSystem.getText());
		}
		catch(Exception e)
		{
			invalidQ = true;
		}
		return numPlanets;
	}

	public int getNumCountries(int numCountries) {
		try
		{
			numCountries = Integer.parseInt(this.numCountries.getText());
		}
		catch (Exception e)
		{
			invalidQ = true;
		}
		return numCountries;
	}

	public Double getaDouble(Double universeRadius) {
		try
		{
			universeRadius = Double.valueOf((universeSize.getText()));
		}
		catch (Exception e)
		{
			invalidQ = true;
		}
		return universeRadius;
	}

	public int getSolarSystemCount(int solarSystemCount) {
		try
		{
			solarSystemCount = Integer.parseInt(numSolarSystem.getText());
		}
		catch (NumberFormatException e)
		{
			invalidQ = true;
		}
		return solarSystemCount;
	}

}
