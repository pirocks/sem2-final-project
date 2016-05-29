package engine.people.cityworkers;

import engine.buildings.workplaces.Hospital;
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
	public Doctor(City parentCity, LocationPlanet location) {
		super(new PeopleInitialConstants(populationInitial,
				foodUsePerPersonInitial,
				crimeRiskInitial,
				crimeImpactInitial,
				salaryInitial,
				parentCity.getParentCountry(),location),parentCity);
	}
	private Doctor(Doctor doctor){
		super(doctor);
	}
    public void doSkill(double time) {
	    Hospital workplace = (Hospital)getWorkBuilding();
	    CityWorker target = workplace.getNextPatient();
        double workDone = time/timeToHealOnePerson;
        int pop = target.getPopulation();
        double healthIncrease = getPopulation()*workDone/((double)pop);
        target.increaseHealth(healthIncrease);
        if(target.getHealth() > 0.9)
        {
            target.leaveHospital();
            if(!workplace.releasePatient(target))
                throw new IllegalStateException();
        }
        paySalary(time);
    }
	@Override
	protected CityWorker splitInternal() {
		return new Doctor(this);
	}
	@Override
    public double getWeight() {
        return 1.5;
    }
}