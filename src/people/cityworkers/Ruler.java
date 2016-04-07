













package people.cityworkers;

import buildings.housing.Housing;
import buildings.workplaces.TownHall;
import buildings.workplaces.Workplace;
import cities.City;
import people.AbstractPerson;
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