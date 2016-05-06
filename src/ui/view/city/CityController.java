package ui.view.city;

import engine.cities.City;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by bob on 4/29/2016.
 *
 */
public class CityController implements Initializable
{
	@FXML
	TextField textField;

	private int homelessPeopleCount;
	private int joblessPeopleCount;
	/*

	 */
	public CityController(City city)
	{
		homelessPeopleCount = city.getHomeless().size();
		joblessPeopleCount = city.getJobLess().size();
//		int = city.
	}




	/**
	 * Called to initialize a controller after its root element has been
	 * completely processed.
	 *
	 * @param location  The location used to resolve relative paths for the root object, or
	 *                  <tt>null</tt> if the location is not known.
	 * @param resources The resources used to localize the root object, or <tt>null</tt> if
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {}
}
