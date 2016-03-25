













package people;
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
    
    public Ruler(City parentCity, Building home)
    {
        super(AbstractPerson.Type.Ruler,parentCity,home);
    }
}