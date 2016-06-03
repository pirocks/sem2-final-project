package engine.people.cityworkers;

import engine.planets.LocationPlanet;
import engine.universe.Country;
import engine.universe.UniversalConstants;

/*
    one ruler per country
*/
public class Ruler extends CityWorker
{
	public static int populationInitial = 1;
	public static double foodUsePerPersonInitial = UniversalConstants.normalFoodUsePerPerson;
	public static double crimeRiskInitial = 0.01*UniversalConstants.normalCrimeRisk;
	public static double crimeImpactInitial = 100.0*UniversalConstants.importantPersonCrimeImpact;
	public static double salaryInitial = 2.0*UniversalConstants.normalPersonSalary;
    //possible deprecation of this object//cannot be deprecated b/c ai
	public Ruler(Country parentCountry, LocationPlanet location) {
		super(new PeopleInitialConstants(populationInitial,
				foodUsePerPersonInitial,
				crimeRiskInitial,
				crimeImpactInitial,
				UniversalConstants.
						getCorruptionFactor(parentCountry)*
						salaryInitial,
				parentCountry,location),parentCountry.getCapitalCity());
	}

	private Ruler(Ruler ruler){
		super(ruler);
	}

    @Override
    public void doSkill(double time) {
		// unimplemented like most rulers this class is useless
    }

	@Override
	protected CityWorker splitInternal() {
		return new Ruler(this);
	}

	@Override
	public double getWeight() {
		return 2;
	}
}