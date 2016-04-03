













package people.cityworkers;

import cities.AbstractPerson;
import cities.Building;
import cities.City;
/*
    one ruler per country
*/
public class Ruler extends AbstractPerson
{
    //possible deprecation of this object//cannot be deprecated b/c ai
    public Ruler(City parentCity, Building home)
    {
        super(AbstractPerson.Type.Ruler,parentCity,home);
    }

    @Override
    public void doSkill(long time) {

    }
}