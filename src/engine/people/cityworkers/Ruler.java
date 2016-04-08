













package engine.people.cityworkers;

import engine.buildings.housing.Housing;
import engine.buildings.workplaces.TownHall;
import engine.buildings.workplaces.Workplace;
import engine.cities.City;
import engine.people.AbstractPerson;
/*
    one ruler per country
*/
public class Ruler extends CityWorker//TODO:clean this up
{
    //possible deprecation of this object//cannot be deprecated b/c ai
    private TownHall workplace;
    public Ruler(City parentCity, Housing home)
    {
        super(AbstractPerson.Type.Ruler,parentCity,home);
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
		//TODO unimplemented
    }
}