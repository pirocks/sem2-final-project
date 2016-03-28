package buildings;
import universe.*;
import cities.*;
import people.*;
import people.cityworkers.*;
import java.util.ArrayList;

public class Hospital extends Building
{
    private ArrayList<Doctor> doctors;//this shouldn't be necesary
    private ArrayList<CityWorker> sickpeople;
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
    
}