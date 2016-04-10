package engine.people.cityworkers;

import engine.buildings.housing.Housing;
import engine.buildings.workplaces.TownHall;
import engine.buildings.workplaces.Workplace;
import engine.cities.City;
import engine.people.AbstractPerson;
import engine.planets.LocationPlanet;

public class Bureaucrat extends CityWorker
{
    private TownHall workplace;
    public Bureaucrat(City parentCity, Housing home)
    {
        super(parentCity,home);
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
        // TODO: 4/9/2016  make sure this ties into ui/ai
    }

    @Override
    public double getWeight() {
        return 0;// TODO: 4/9/2016
    }
}