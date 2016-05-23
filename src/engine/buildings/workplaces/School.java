package engine.buildings.workplaces;

import engine.cities.CityBlock;
import engine.people.cityworkers.CityWorker;
import engine.people.cityworkers.Teacher;
import engine.tools.AttackableConstants;
import engine.universe.MoneySource;
import engine.universe.ResourceDemand;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.HashMap;

public class School extends Workplace
{
	public static double healthInitial;
	public static double resistanceInitial;
	public static int maxWorkersInitial;// TODO: 5/19/2016

	public School(CityBlock parentBlock, MoneySource owner) {
		super(new AttackableConstants(healthInitial,resistanceInitial,parentBlock.getLocation()), parentBlock, maxWorkersInitial, owner);
	}

	@Override
	protected String getName() {
		return "School";
	}

	@Override
	public ResourceDemand getResourceCost() {
		return null;// TODO: 4/9/2016
	}

	@Override
	public void addSpecific(VBox in) {
		HashMap<String,Integer> typesOfStudents = new HashMap<>();
		for (CityWorker cityWorker : super.getWorkers()) {
			if(cityWorker instanceof Teacher)
				typesOfStudents.put(((Teacher)cityWorker).getStudent().getClass().getCanonicalName(), cityWorker.getPopulation());
		}
		for (String s : typesOfStudents.keySet()) {
			in.getChildren().add(new Text(s + ":"+ typesOfStudents.get(s)));
		}


	}

	//no member vars needed, teachers have all vars required
	
}