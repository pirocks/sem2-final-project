













package people.cityworkers;

import buildings.housing.Housing;
import buildings.workplaces.School;
import cities.City;
import people.AbstractPerson;

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