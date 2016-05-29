package engine.people.cityworkers;

import engine.cities.City;
import engine.planets.LocationPlanet;
import engine.universe.UniversalConstants;

public class Bureaucrat extends CityWorker implements Cloneable
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
	public Bureaucrat(City parentCity,LocationPlanet location) {
	    super(new PeopleInitialConstants(populationInitial, foodUsePerPersonInitial, UniversalConstants.getCorruptionFactor(parentCity.getParentCountry())*crimeRiskInitial, crimeImpactInitial, salaryInitial, parentCity.getParentCountry(),location),parentCity);
    }
	private Bureaucrat(Bureaucrat  bureaucrat){
		super(bureaucrat);
	}
    @Override
    public void doSkill(double time) {
        // TODO: 4/9/2016  make sure this ties into ui/ai
        //really this has nothing to do , in fact the args don't allow for any sort of management.
		//so just charge the salarygiver for time
	    paySalary(time);
    }
	@Override
	protected CityWorker splitInternal() {
		return new Bureaucrat(this);
	}
	@Override
    public double getWeight() {
        return 2;
    }
}