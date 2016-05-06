package engine.people.cityworkers;

import engine.buildings.housing.Housing;
import engine.buildings.workplaces.TownHall;
import engine.buildings.workplaces.Workplace;
import engine.cities.City;
import engine.people.AbstractPerson;
import engine.planets.LocationPlanet;
import engine.universe.UniversalConstants;

public class Bureaucrat extends CityWorker
{
	public static int populationInitial = 100;
	public static double foodUsePerPersonInitial =
			UniversalConstants.normalFoodUsePerPerson;
	public static double crimeRiskInitial =
			UniversalConstants.normalCrimeRisk;
	public static double crimeImpactInitial =
			UniversalConstants.importantPersonCrimeImpact;
	public static double salaryInitial =
			2.0*UniversalConstants.normalPersonSalary;
	private TownHall workplace;
    public static double bureaucratSalary;//secondly value
	public Bureaucrat(City parentCity,LocationPlanet location)
    {
	    super(new PeopleInitialConstants(populationInitial,
			    foodUsePerPersonInitial,
			    UniversalConstants.
					    getCorruptionFactor(parentCity.getParentCountry())
					    *crimeRiskInitial,
			    crimeImpactInitial,
			    salaryInitial,
			    parentCity.getParentCountry(),location),parentCity);

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
	    salaryGiver.pay(moneySource,bureaucratSalary*time);
    }

    @Override
    public double getWeight() {
        return 0;// TODO: 4/9/2016
    }
}