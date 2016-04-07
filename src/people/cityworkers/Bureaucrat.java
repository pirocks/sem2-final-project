package people.cityworkers;

import buildings.housing.Housing;
import buildings.workplaces.TownHall;
import buildings.workplaces.Workplace;
import cities.City;
import people.AbstractPerson;

public class Bureaucrat extends CityWorker
{
    TownHall workplace;
    public Bureaucrat(City parentCity, Housing home)
    {
        super(AbstractPerson.Type.Bureaucrat,parentCity,home);
    }

    @Override
    public Workplace getWorkBuilding() {
        return workplace;
    }

    @Override
    public void setWorkPlaceToNull() {
        workplace = null;
    }

    @Override
    public void doSkill(long time) {

    }
}