package people.cityworkers;

import buildings.Housing;
import buildings.Workplace;
import cities.AbstractPerson;
import cities.City;
import people.CityWorker;

public class Bureaucrat extends CityWorker
{
    public Bureaucrat(City parentCity, Housing home)
    {
        super(AbstractPerson.Type.Bureaucrat,parentCity,home);
    }

    @Override
    public Workplace getWorkBuilding() {
        return null;
    }

    @Override
    public void doSkill(long time) {

    }
}