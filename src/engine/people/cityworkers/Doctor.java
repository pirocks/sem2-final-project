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
		workplace = doctor.getWorkBuilding();
		registerContainer(workplace);// TODO: 5/29/2016 implment remove
	}
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
    public void doSkill(double time)//time is in seconds
    {
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
        return 0;// TODO: 4/9/2016
    }
}