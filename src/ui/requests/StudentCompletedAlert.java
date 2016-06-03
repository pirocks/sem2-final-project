package ui.requests;

import engine.cities.City;
import engine.people.AbstractPerson;
import engine.people.cityworkers.CityWorker;
import engine.people.cityworkers.Teacher;
import engine.planets.LocationPlanet;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import ui.view.Controller;

import java.util.Optional;

/**
 * Created by bob on 6/2/2016.
 */
public class StudentCompletedAlert<Type extends AbstractPerson> {
	private LocationPlanet location;
	private City city;
	private CityWorker cityWorker;
	private Alert alert;

	public StudentCompletedAlert(City city, CityWorker cityWorker, Teacher teacher, LocationPlanet location) {
		this.city = city;
		this.cityWorker = cityWorker;
		alert = new Alert(Alert.AlertType.CONFIRMATION,"A school finished creating " + cityWorker.getPopulation() + "" +
				" " + cityWorker.getClass().getSimpleName(),new ButtonType("Ok"),new ButtonType("Take Me to the City"),new ButtonType("Select what the school will build next"));
		this.location = location;
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				Optional<ButtonType> buttonType = alert.showAndWait();
				if (buttonType.isPresent()) {
					if (buttonType.get().getText().equals("Select what the school will build next")) {
						new WorkerTypeRequest(teacher,city, location);
					}
					if(buttonType.get().getText().equals("Take Me to the City")){
						Controller.controller.switchTo(city);
					}
				}
			}
		});
	}
}
