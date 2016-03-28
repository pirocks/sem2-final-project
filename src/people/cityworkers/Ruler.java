













package people.cityworkers;
import cities.AbstractPerson;
import universe.UniversalConstants;
import planets.Country;
import cities.City;
import cities.Building;
/*
    one ruler per country
*/
public class Ruler extends AbstractPerson
{
    //possible deprecation of this object
    public Ruler(City parentCity, Building home)
    {
        super(AbstractPerson.Type.Ruler,parentCity,home);
    }
}