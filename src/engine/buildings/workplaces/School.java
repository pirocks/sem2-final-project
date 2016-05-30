package engine.buildings.workplaces;

import engine.cities.CityBlock;
import engine.people.cityworkers.CityWorker;
import engine.people.cityworkers.Teacher;
import engine.planets.LocationPlanet;
import engine.tools.AttackableConstants;
import engine.universe.MoneySource;
import engine.universe.Resource;
import engine.universe.ResourceDemand;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import ui.requests.WorkerTypeRequest;

import java.util.HashMap;

public class School extends Workplace
{
	public static double healthInitial = 7000;
	public static double resistanceInitial = 500;
	public static int maxWorkersInitial = 500;

	private School selfReference;

	public School(CityBlock parentBlock, MoneySource owner) {
		super(new AttackableConstants(healthInitial,resistanceInitial,parentBlock.getLocation()), parentBlock, maxWorkersInitial, owner);
		selfReference = this;
	}

	@Override
	protected String getName() {
		return "School";
	}

	@Override
	public ResourceDemand getResourceCost() {
		return new ResourceDemand(new Resource.Type[] {},healthInitial,resistanceInitial,maxWorkersInitial);
	}

	@Override
	protected boolean isSuitableType(CityWorker cityWorker) {
		return cityWorker instanceof Teacher;
	}

	@Override
	public void addSpecific(VBox in) {
		HashMap<String,Integer> typesOfStudents = new HashMap<>();
		for (CityWorker cityWorker : super.getWorkers()) {
			if (cityWorker instanceof Teacher) {
				if (((Teacher) cityWorker).getStudent() != null)
					typesOfStudents.put(((Teacher) cityWorker).getStudent().getClass().getCanonicalName(), cityWorker.getPopulation());
				else
					in.getChildren().add(new Button("Add student"){{
						setOnMouseClicked(new EventHandler<MouseEvent>() {
							@Override
							public void handle(MouseEvent event) {
								new WorkerTypeRequest(selfReference);
							}
						});
					}});
			}
		}
		for (String s : typesOfStudents.keySet()) {
			in.getChildren().add(new Text(s + ":"+ typesOfStudents.get(s)));
		}


	}

	@Override
	public CityWorker createCorrectType() {
		return new Teacher<>(getParentCity(),new LocationPlanet(this));
	}

	//no member vars needed, teachers have all vars required
	
}