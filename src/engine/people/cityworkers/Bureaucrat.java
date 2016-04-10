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
    public static double bureaucratSalary;//secondly value
	public Bureaucrat(City parentCity, Housing home)
    {
        super(parentCity,home);
//	    salaryGiver = workplace.
    }

    @Override
    public TownHall getWorkBuilding() {
        return workplace;
    }

    @Override
    public void setWorkPlaceToNull() {
        workplace = null;
    }

    @Override
    public void doSkill(long time) {
        // TODO: 4/9/2016  make sure this ties into ui/ai
        //really this has nothing to do , in fact the args don't allow for any sort of management.
		//so just charge the salarygiver for time
	    salaryGiver.pay(this,bureaucratSalary*time);
    }

    @Override
    public double getWeight() {
        return 0;// TODO: 4/9/2016
    }
}