package ui.requests;

import engine.buildings.housing.Housing;
import engine.buildings.workplaces.InCorrectWorkerTypeException;
import engine.buildings.workplaces.ToManyWorkersException;
import engine.buildings.workplaces.Workplace;
import engine.cities.City;
import engine.cities.ToManyPeopleException;
import engine.people.AbstractPerson;
import engine.people.cityworkers.CityWorker;
import engine.people.cityworkers.Teacher;
import engine.planets.LocationPlanet;
import engine.universe.Universe;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import ui.view.Controller;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Created by bob on 6/2/2016.
 */
public class StudentCompletedAlert<Type extends AbstractPerson> {
	private LocationPlanet location;
	private City city;
	private AbstractPerson cityWorker;
	private Alert alert;
	private static boolean notificationUp = false;
	public StudentCompletedAlert(City city, AbstractPerson cityWorker, Teacher teacher, LocationPlanet location) {
		if (!notificationUp && city.getParentCountry() == Universe.playersCountry) {
			notificationUp = true;
			this.city = city;
			this.cityWorker = cityWorker;
			alert = new Alert(Alert.AlertType.CONFIRMATION,"A school finished creating " + cityWorker.getPopulation() + "" +
					" " + cityWorker.getClass().getSimpleName(),new ButtonType("Ok"),new ButtonType("Take Me to the City"),new ButtonType("Select what the school will build next"));
			Housing emptyHousing = city.findEmptyHousing(cityWorker.getPopulation());
			try {
				emptyHousing.addResidents(new ArrayList<CityWorker>() {{add((CityWorker)cityWorker);}});
			} catch (ToManyPeopleException e) {
				e.printStackTrace();
			}catch (NullPointerException e){
				alert.setContentText(alert.getContentText() + "Warning this newly built person, could not find a home" +
						".");
			}
			try {
				employWorker(city, (CityWorker) cityWorker,10);
			} catch (NoSuchFieldException e) {
				alert.setContentText(alert.getContentText()  + "Warning this newly built person, could not find " +
						"employment");
			}
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
					notificationUp = false;
				}
			});
		}
		return;
	}

	private void employWorker(City city, CityWorker cityWorker, int i) throws NoSuchFieldException {
		if(i == 0){
			throw new NoSuchFieldException();
		}
		Workplace suitableEmployment = city.findSuitableEmployment(cityWorker);
		try {
			suitableEmployment.addWorker(cityWorker);
		} catch (ToManyWorkersException e) {
			employWorker(city,cityWorker,i - 1);
		} catch (InCorrectWorkerTypeException e) {
			e.printStackTrace();
		}
	}
}
