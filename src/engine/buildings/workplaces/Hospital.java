package engine.buildings.workplaces;

import engine.cities.CityBlock;
import engine.people.AbstractPerson;
import engine.people.cityworkers.CityWorker;
import engine.people.cityworkers.Doctor;
import engine.planets.LocationPlanet;
import engine.tools.AttackableConstants;
import engine.universe.MoneySource;
import engine.universe.ResourceDemand;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class Hospital extends Workplace
{
	public static double healthInitial;// TODO: 5/29/2016
	public static double resistanceInitial;// TODO: 5/29/2016
	public static int maxWorkersInitial = 1000;
	private ArrayList<CityWorker> sickPeople;
	public Hospital(CityBlock parentBlock, MoneySource owner) {
		super(new AttackableConstants(healthInitial,resistanceInitial,parentBlock.getLocation()), parentBlock, maxWorkersInitial, owner);
		sickPeople = new ArrayList<>();
	}
	public CityWorker getNextPatient() {
    	int i = sickPeople.size() - 1;
    	if(i < 0)
    		return null;
    	return sickPeople.get(i);
    }
    public void admit(CityWorker cityworker)
	{
		sickPeople.add(cityworker);
    }
    public double getWorkLoad() {
    	double load = 0;
    	for(CityWorker sickperson: sickPeople)
    		load += (1.0 - sickperson.getHealth())*sickperson.getPopulation();
    	return load;
    }
    public boolean releasePatient(CityWorker p)
    {
        return sickPeople.remove(p);
    }
	@Override
	protected boolean isSuitableType(CityWorker cityWorker) {
		return cityWorker instanceof Doctor;
	}
	public void leavePerson(AbstractPerson person) {
	    assert(sickPeople.contains(person));
	    sickPeople.remove(person);
    }
	private int getSickPeoplePopulation(){
		int out = 0;
		for (CityWorker cityWorker : sickPeople) {
			out += cityWorker.getPopulation();
		}
		return out;
	}
	@Override
	public void addSpecific(VBox in) {
		in.getChildren().add(new Text("num sick people:" + getSickPeoplePopulation()));
		in.getChildren().add(new Text("Average city health:"));
		double averageHealth = getParentCity().getAverageHealth();
		if(averageHealth < 0.3)
			in.getChildren().add(new Text("Very Bad(the city is literally dying)"));
		else if(averageHealth < 0.5)
			in.getChildren().add(new Text("Bad"));
		else if(averageHealth < 0.7)
			in.getChildren().add(new Text("Okay"));
		else if(averageHealth < 0.9)
			in.getChildren().add(new Text("Good"));
		else
			in.getChildren().add(new Text("Very Good"));
	}
	@Override
	public CityWorker createCorrectType() {
		return new Doctor(getParentCity(),new LocationPlanet(this));
	}
	@Override
	protected String getName() {
		return "Hospital";
	}
	@Override
	public ResourceDemand getResourceCost() {
		return null;// TODO: 4/9/2016
	}

}