













package people.cityworkers;

import buildings.workplaces.School;
import cities.AbstractPerson;
import cities.Building;
import cities.City;
public class Teacher extends AbstractPerson
{
    public double progress = 0.0;//from 0 to 1
    public AbstractPerson.Type studentType;
    public School workplace;
    public Teacher(City parentCity,Building home)
    {
		super(AbstractPerson.Type.Teacher,parentCity,home);
    }
    public School getWorkBuilding()
    {
        return workplace;
    }
    public void doSkill(long time)
    {
        //unimplmented
    }
}