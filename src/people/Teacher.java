













package people;
import cities.AbstractPerson;
import universe.UniversalConstants;
import planets.Country;
import cities.City;
import cities.Building;
public class Teacher extends AbstractPerson
{
    public Teacher(City parentCity,Building home)
    {
		super(AbstractPerson.Type.Teacher,parentCity,home);
    }
}