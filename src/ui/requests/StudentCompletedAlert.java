package ui.requests;

import engine.cities.City;
import engine.people.cityworkers.CityWorker;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

/**
 * Created by bob on 6/2/2016.
 */
public class StudentCompletedAlert<Type extends CityWorker> {
	private City city;
	private CityWorker cityWorker;
	private Alert alert;

	public StudentCompletedAlert(City city, CityWorker cityWorker) {
		this.city = city;
		this.cityWorker = cityWorker;
		alert = new Alert(Alert.AlertType.CONFIRMATION,"A school finished creating " + cityWorker.getPopulation() + "" +
				" " + cityWorker.getClass().getSimpleName(),new ButtonType("Ok"),new ButtonType("Take Me to the " +
				"City"),new ButtonType("Select what the school will build next"));
		Optional<ButtonType> buttonType = alert.showAndWait();
		if (buttonType.isPresent()) {

		}
	}
}
