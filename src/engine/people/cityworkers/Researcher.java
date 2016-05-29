package engine.people.cityworkers;

import engine.buildings.workplaces.ResearchArea;
import engine.buildings.workplaces.Workplace;
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
    private ResearchArea workplace;
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
		workplace = getWorkBuilding();
		registerContainer(workplace);// TODO: 5/29/2016 implment remove
	}

	@Override
	protected void setWorkplace(Workplace workplace) {
		this.workplace = (ResearchArea) workplace;
	}

	public ResearchArea getWorkBuilding()
    {
        return workplace;
    }
    @Override
    public void setWorkPlaceToNull() {
        workplace = null;
    }
    @Override
    public void doSkill(double time) {
	    assert (workplace.getDiscovery().canBeResearched());
        workplace.getDiscovery().makeProgress(time/UniversalConstants.timeToDiscoveryConstant);
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