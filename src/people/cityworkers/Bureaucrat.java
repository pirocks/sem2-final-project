package people.cityworkers;

import buildings.housing.Housing;
import buildings.workplaces.Workplace;
import cities.City;
import people.AbstractPerson;
import trash.CityWorker;

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