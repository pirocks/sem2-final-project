package buildings.workplaces;

import cities.CityBlock;
import people.AbstractPerson;
import people.cityworkers.CityWorker;
import universe.MoneySource;

import java.util.ArrayList;

public class Hospital extends Workplace
{
	public static int maximumOccupancyInitial = -1;
	public static double costInitial;
	public static double resistanceInitial;
    // private ArrayList<Doctor> doctors;//this shouldn't be necesary
    private ArrayList<CityWorker> sickpeople;

	public Hospital(Type type, ArrayList<CityWorker> workers, CityBlock parentBlock, MoneySource owner) {
		super(type, workers, parentBlock, owner);
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
}