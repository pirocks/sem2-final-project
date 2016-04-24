package engine.people.cityworkers;

import engine.buildings.housing.Housing;
import engine.buildings.workplaces.TownHall;
import engine.buildings.workplaces.Workplace;
import engine.cities.City;
import engine.people.AbstractPerson;
import engine.universe.Country;
import engine.universe.UniversalConstants;

/*
    one ruler per country
*/
public class Ruler extends CityWorker //TODO:clean this up
{
	public static int populationInitial = 1;
	public static double foodUsePerPersonInitial = UniversalConstants.normalFoodUsePerPerson;
	public static double crimeRiskInitial = 0.01*UniversalConstants.normalCrimeRisk;
	public static double crimeImpactInitial = 100.0*UniversalConstants.importantPersonCrimeImpact;
	public static double salaryInitial = 2.0*UniversalConstants.normalPersonSalary;
    //possible deprecation of this object//cannot be deprecated b/c ai
    private TownHall workplace;
	public Ruler(Country parentCountry) {
		super(new PeopleInitialConstants(populationInitial,
				foodUsePerPersonInitial,
				crimeRiskInitial,
				crimeImpactInitial,
				UniversalConstants.
						getCorruptionFactor(parentCountry)*
						salaryInitial,
				parentCountry),parentCountry.getCapitalCity());
	}

    @Override
    public Workplace getWorkBuilding() {
        return workplace;
    }

    @Override
    public void setWorkPlaceToNull() {
		workplace = null;
    }

    @Override
    public void doSkill(long time) {
		//TODO unimplemented
        //needs to tie into ai and ui
    }

	@Override
	public double getWeight() {
		return 0;// TODO: 4/9/2016
	}
}