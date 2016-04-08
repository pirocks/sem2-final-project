package engine.people.cityworkers;

import engine.buildings.housing.Housing;
import engine.buildings.workplaces.TownHall;
import engine.buildings.workplaces.Workplace;
import engine.cities.City;
import engine.people.AbstractPerson;

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