package ui.requests;

import engine.cities.City;
import engine.people.AbstractPerson;
import engine.people.cityworkers.*;
import engine.planets.LocationPlanet;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

/**
 * Created by user on 4/13/2016.
 *
 */
public class WorkerTypeRequest extends Request
{
	private Teacher teacher;
	private City city;
	private LocationPlanet locationPlanet;
	public WorkerTypeRequest(Teacher teacher, City city, LocationPlanet locationPlanet){
		super();
		this.teacher = teacher;
		this.city = city;
		this.locationPlanet = locationPlanet;
		Alert dialog = new Alert(Alert.AlertType.NONE);
		dialog.setContentText("Select the type of worker you want to build");
		dialog.setTitle("Select the type of worker you want to build");
		dialog.getButtonTypes().add(new ButtonType("Build 250 teachers"));
		dialog.getButtonTypes().add(new ButtonType("Build 100 Bureaucrats"));
		dialog.getButtonTypes().add(new ButtonType("Build 100 Doctors"));
		dialog.getButtonTypes().add(new ButtonType("Build 100 ManualWorkers"));
		dialog.getButtonTypes().add(new ButtonType("Build 100 Researchers"));
		Optional<ButtonType> buttonType = dialog.showAndWait();
		if(buttonType.isPresent()){
			if(buttonType.get().equals("Build 250 teachers"))
				teacher.setStudent(new Teacher<AbstractPerson>(city,locationPlanet));
			if(buttonType.get().equals("Build 100 Bureaucrats"))
				teacher.setStudent(new Bureaucrat(city,locationPlanet));
			if(buttonType.get().equals("Build 100 Doctors"))
				teacher.setStudent(new Doctor(city,locationPlanet));
			if(buttonType.get().equals("Build 100 ManualWorkers"))
				teacher.setStudent(new ManualWorker(city,locationPlanet));
			if(buttonType.get().equals("Build 100 Researchers"))
				teacher.setStudent(new Researcher(city,locationPlanet));

		}
	}
}
