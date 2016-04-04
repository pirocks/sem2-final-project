













package people.cityworkers;

import buildings.Building;
import cities.City;
import people.AbstractPerson;
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