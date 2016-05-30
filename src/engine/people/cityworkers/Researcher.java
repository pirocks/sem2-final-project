package engine.people.cityworkers;

import engine.buildings.workplaces.ResearchArea;
import engine.cities.City;
import engine.planets.LocationPlanet;
import engine.universe.UniversalConstants;

public class Researcher extends CityWorker implements Cloneable
{
    public static int populationInitial = 100;
    public static double foodUsePerPersonInitial = UniversalConstants.normalFoodUsePerPerson;
    public static double crimeRiskInitial = UniversalConstants.normalCrimeRisk;
    public static double crimeImpactInitial = UniversalConstants.importantPersonCrimeImpact;
    public static double salaryInitial = 2.0*UniversalConstants.normalPersonSalary;
	public Researcher(City parentCity, LocationPlanet location) {
		super(new PeopleInitialConstants(populationInitial,
				foodUsePerPersonInitial,
				crimeRiskInitial,
				crimeImpactInitial,
				salaryInitial,
				parentCity.getParentCountry(),location),parentCity);
	}

	private Researcher(Researcher researcher){
		super(researcher);
	}
	@Override
    public void doSkill(double time) {
		if(getWorkBuilding() != null && ((ResearchArea)getWorkBuilding()).getDiscovery() != null) {
			assert (((ResearchArea) getWorkBuilding()).getDiscovery().canBeResearched());
			((ResearchArea) getWorkBuilding()).getDiscovery().makeProgress(time / UniversalConstants.timeToDiscoveryConstant);
			paySalary(time);
		}
    }
	@Override
	protected CityWorker splitInternal() {
		return new Researcher(this);
	}
	@Override
    public double getWeight() {
        return 1.25;
    }
}