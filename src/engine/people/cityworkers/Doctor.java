package engine.people.cityworkers;

import engine.buildings.workplaces.Hospital;
import engine.buildings.workplaces.Workplace;
import engine.cities.City;
import engine.planets.LocationPlanet;
import engine.universe.UniversalConstants;

//import engine.buildings.workplace.*;


public class Doctor extends CityWorker implements Cloneable
{
	public static int populationInitial = 100;
	public static double foodUsePerPersonInitial = UniversalConstants.normalFoodUsePerPerson;
	public static double crimeRiskInitial = UniversalConstants.normalCrimeRisk;
	public static double crimeImpactInitial = UniversalConstants.importantPersonCrimeImpact;
	public static double salaryInitial = 2.0*UniversalConstants.normalPersonSalary;
	public static long timeToHealOnePerson = 3600*24;
    private Hospital workplace;

	@Override
	protected void setWorkplace(Workplace workplace) {
		this.workplace = (Hospital) workplace;
	}

	public Hospital getWorkBuilding()
    {
        return workplace;
    }

    @Override
    public void setWorkPlaceToNull() {
        workplace = null;
    }

    public Doctor(City parentCity, LocationPlanet location) {
        super(new PeopleInitialConstants(populationInitial,
		        foodUsePerPersonInitial,
		        crimeRiskInitial,
		        crimeImpactInitial,
		        salaryInitial,
		        parentCity.getParentCountry(),location),parentCity);
    }
    public void doSkill(long time)//time is in seconds
    {
        //use productivity;
        //not sure if this is good yet
	    // TODO: 4/10/2016 need to reread this at some point
	    CityWorker target = workplace.getNextPatient();//mybe make this an array or city
        double workDone = time/timeToHealOnePerson;
        int pop = target.getPopulation();
        double healthIncrease = workDone/((double)pop);
        if(1.0 - target.getHealth() < healthIncrease)
            healthIncrease = 1.0 - target.getHealth();
        if(salaryGiver.canPay(getSalary()*healthIncrease))
        {    
            target.increaseHealth(healthIncrease);
            salaryGiver.pay(moneySource,getSalary()*healthIncrease);
            if(target.getHealth() > 0.99)
            {
                target.leaveHospital();
                if(!workplace.releasePatient(target))
                    assert(false);
            }
        }
        else
        {
            salaryGiver.outOfMoneyHandler(getSalary()*healthIncrease);
        }
    }

    @Override
    public double getWeight() {
        return 0;// TODO: 4/9/2016
    }
}