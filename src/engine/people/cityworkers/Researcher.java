package engine.people.cityworkers;

import engine.buildings.housing.Housing;
import engine.buildings.workplaces.ResearchArea;
import engine.cities.City;
import engine.people.AbstractPerson;
import engine.planets.LocationPlanet;
import engine.universe.UniversalConstants;

public class Researcher extends CityWorker
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
    public ResearchArea getWorkBuilding()
    {
        return workplace;
    }
    @Override
    public void setWorkPlaceToNull() {
        workplace = null;
    }
    @Override
    public void doSkill(long time) {
        //TODO:implement
    }
    @Override
    public double getWeight() {
        return 0;// TODO: 4/9/2016
    }
}