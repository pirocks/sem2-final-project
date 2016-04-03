















package people.cityworkers;

import cities.AbstractPerson;
import cities.Building;
import cities.City;
public abstract class Worker extends AbstractPerson
{
    //this class is too vague
    public Worker(City parentCity,Building home)
    {
        super(AbstractPerson.Type.Worker,parentCity,home);
    }
    
}