













package people.cityworkers;
import cities.AbstractPerson;
import universe.UniversalConstants;
import planets.Country;
import cities.City;
import cities.Building;
public class Teacher extends AbstractPerson
{
    public double progress = 0.0;//from 0 to 1
    public AbstractPerson.Type studentType;
    public Teacher(City parentCity,Building home)
    {
		super(AbstractPerson.Type.Teacher,parentCity,home);
    }
}