package people.cityworkers;

import buildings.Building;
import cities.City;
import people.AbstractPerson;
public abstract class Worker extends AbstractPerson
{
    //this class is too vague//this class is uslesss deprecated
    public Worker(City parentCity,Building home)
    {
        super(AbstractPerson.Type.Worker,parentCity,home);
    }
    
}