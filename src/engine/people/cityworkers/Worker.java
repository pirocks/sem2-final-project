package engine.people.cityworkers;

import engine.buildings.housing.Housing;
import engine.buildings.workplaces.Workplace;
import engine.cities.City;
import engine.universe.UniversalConstants;

/**
 * Created by bob on 4/10/2016.
 *
 */
public class Worker extends CityWorker
{
	public static int populationInitial = 1000;
	public static double foodUsePerPersonInitial = UniversalConstants.normalFoodUsePerPerson;
	public static double crimeRiskInitial = UniversalConstants.normalCrimeRisk;
	public static double crimeImpactInitial = 0.01*UniversalConstants.normalPersonCrimeImpact;
	public static double salaryInitial = UniversalConstants.normalPersonSalary;

	public Worker(City parentCity) {
		super(new PeopleInitialConstants(populationInitial,
				foodUsePerPersonInitial,
				crimeRiskInitial,
				crimeImpactInitial,
				salaryInitial,
				parentCity.getParentCountry()),parentCity);
	}

	@Override
	public Workplace getWorkBuilding() {
		return null;// TODO: 4/10/2016
	}

	@Override
	public void setWorkPlaceToNull() {
		// TODO: 4/10/2016  //what the fuck is this method
	}

	@Override
	public void doSkill(long time) {
		// TODO: 4/10/2016
	}

	@Override
	public double getWeight() {
		return 0;// TODO: 4/10/2016
	}
}
