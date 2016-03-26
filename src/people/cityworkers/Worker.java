















package people.cityworkers;
import cities.AbstractPerson;
import universe.UniversalConstants;
import planets.Country;
import cities.Building;
import cities.City;
public class Worker extends AbstractPerson
{
    public Worker(City parentCity,Building home)
    {
        super(AbstractPerson.Type.Worker,parentCity,home);
    }
}