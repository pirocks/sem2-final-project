package engine.buildings.workplaces;

import engine.cities.CityBlock;
import engine.people.AbstractPerson;
import engine.people.cityworkers.CityWorker;
import engine.tools.AttackableConstants;
import engine.universe.MoneySource;
import engine.universe.ResourceDemand;

import java.util.ArrayList;

public class Hospital extends Workplace
{
	public static double healthInitial;
	public static double resistanceInitial;
	public static int maximumOccupancyInitial = -1;
	// private ArrayList<Doctor> doctors;//this shouldn't be necesary
    private ArrayList<CityWorker> sickPeople;

	public Hospital(CityBlock parentBlock, MoneySource owner) {
		super(new AttackableConstants(healthInitial,resistanceInitial,parentBlock.getLocation()), parentBlock, owner);
		sickPeople = new ArrayList<>();
	}

	public CityWorker getNextPatient()
    {
    	int i = sickPeople.size() - 1;
    	if(i < 0)
    		return null;
    	return sickPeople.get(i);
    }
    public void admit(CityWorker cityworker)
	{
		sickPeople.add(cityworker);
    }
    public double getWorkLoad()
    {
    	double load = 0;
    	for(CityWorker sickperson: sickPeople)
    		load += (1.0 - sickperson.getHealth())*sickperson.getPopulation();
    	return load;
    }
    public boolean releasePatient(CityWorker p)
    {
        return sickPeople.remove(p);
    }
    public void leavePerson(AbstractPerson person)
    {
	    assert(sickPeople.contains(person));
	    sickPeople.remove(person);
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