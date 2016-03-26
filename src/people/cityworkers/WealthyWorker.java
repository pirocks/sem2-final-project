















package people.cityworkers;
import cities.AbstractPerson;
import cities.City;
import cities.Building;

public class WealthyWorker extends AbstractPerson
{
	public WealthyWorker(City parentCity,Building home)
	{
		super(AbstractPerson.Type.WealthyWorker,parentCity,home);
	}
}