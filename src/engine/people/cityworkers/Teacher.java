













package engine.people.cityworkers;

import engine.buildings.housing.Housing;
import engine.buildings.workplaces.School;
import engine.cities.City;
import engine.people.AbstractPerson;

public class Teacher extends CityWorker
{
    public double progress = 0.0;//from 0 to 1
    public AbstractPerson.Type studentType;
    public School workplace;
    public Teacher(City parentCity,Housing home)
    {
		super(AbstractPerson.Type.Teacher,parentCity,home);
    }
    public School getWorkBuilding()
    {
        return workplace;
    }

    @Override
    public void setWorkPlaceToNull() {
        workplace = null;
    }

    public void doSkill(long time)
    {
        //TODO:unimplmented
    }

}