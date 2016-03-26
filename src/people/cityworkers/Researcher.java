

















package people.cityworkers;
import cities.AbstractPerson;
import universe.UniversalConstants;
import planets.Country;
import cities.City;
import cities.Building;
public class Researcher extends AbstractPerson
{
    public Researcher(City parentCity, Building home)
    {
		super(AbstractPerson.Type.Researcher,parentCity,home);
    }
    
}