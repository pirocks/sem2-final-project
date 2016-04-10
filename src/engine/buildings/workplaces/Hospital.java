package engine.buildings.workplaces;

import engine.cities.CityBlock;
import engine.people.AbstractPerson;
import engine.people.cityworkers.CityWorker;
import engine.tools.AttackableInitialConstants;
import engine.universe.MoneySource;
import engine.universe.ResourceDemand;

import java.util.ArrayList;

public class Hospital extends Workplace
{
	public static double healthInitial;
	public static double resistanceInitial;
	public static int maximumOccupancyInitial = -1;
	public static double costInitial;
    // private ArrayList<Doctor> doctors;//this shouldn't be necesary
    private ArrayList<CityWorker> sickpeople;

	public Hospital(CityBlock parentBlock, MoneySource owner) {
		super(new AttackableInitialConstants(healthInitial,resistanceInitial), parentBlock, owner);
	}

	public CityWorker getNextPatient()
    {
    	int i = sickpeople.size() - 1;
    	if(i < 0)
    		return null;
    	return sickpeople.get(i);
    }
    public void admit(CityWorker cityworker)
	{
		sickpeople.add(cityworker);
    }
    public double getWorkLoad()
    {
    	double load = 0;
    	for(CityWorker sickperson: sickpeople)
    		load += (1.0 - sickperson.getHealth())*sickperson.getPopulation();
    	return load;
    }
    public boolean releasePatient(CityWorker p)
    {
        return sickpeople.remove(p);
    }
    public void leavePerson(AbstractPerson person)
    {
	    assert(sickpeople.contains(person));
	    sickpeople.remove(person);
    }

	@Override
	public ResourceDemand getResourceCost() {
		return null;// TODO: 4/9/2016
	}

	@Override
	public double getCost() {
		return costInitial;
	}
}