















package people.cityworkers;
import cities.AbstractPerson;
import cities.City;
import cities.Building;

public class WealthyWorker extends AbstractPerson
{
	//possible deprecation of this object//however probably not//actually yes
	public WealthyWorker(City parentCity,Building home)
	{
		super(AbstractPerson.Type.WealthyWorker,parentCity,home);
	}
}