package ui.welcomescreen;

import engine.universe.UniverseGenerator;
import engine.universe.UniverseRandomConstructionContext;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.net.URL;
import java.util.*;



public class Controller implements Initializable {

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
	TextField numEnemyCountries;
	@FXML
	TextField universeSize;

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
		System.out.println("working");
	}
	@FXML public void generateClicked()
	{
		int solaySystemCount= 50;
		try
		{
			solaySystemCount = Integer.parseInt(numSolarSystem.getText());
		}
		catch (NumberFormatException e)
		{
			// TODO: 5/7/2016 handle invalid values
			e.printStackTrace();
		}
		Double universeRadius = Double.MAX_VALUE;
		try
		{
			universeRadius = Double.valueOf((universeSize.getText()));
		}
		catch (Exception e)
		{
			// TODO: 5/7/2016 handle invalid
			e.printStackTrace();
		}
		int numCountries = 10;
		try
		{
			numCountries = Integer.parseInt(numEnemyCountries.getText());
		}
		catch (Exception e)
		{
			e.printStackTrace();// TODO: 5/7/2016
		}
		int numPlanets = 500;
		try
		{
			numPlanets = solaySystemCount*Integer.parseInt(numPlanetsPerSolarSystem.getText());
		}
		catch(Exception e)
		{
			e.printStackTrace();// TODO: 5/7/2016
		}

		UniverseGenerator generator = new UniverseGenerator(
				new UniverseRandomConstructionContext(
						solaySystemCount,universeRadius,
						numCountries,numPlanets,numPlanets
				));
		Thread universeGenerationThread = new Thread(generator);
		universeGenerationThread.run();

	}

}
