package engine.people.cityworkers;

import engine.buildings.workplaces.Workplace;
import engine.cities.City;
import engine.planets.LocationPlanet;
import engine.universe.UniversalConstants;

/**
 * Created by bob on 5/26/2016.
 *
 */
public class ManualWorker extends CityWorker {
	private Workplace workplace;
	public static int populationInitial = 1000;
	public static double foodUsePerPersonInitial = UniversalConstants.normalFoodUsePerPerson;
	public static double crimeRiskInitial = UniversalConstants.normalCrimeRisk;
	public static double crimeImpactInitial = UniversalConstants.normalPersonCrimeImpact;
	public static double salaryInitial = UniversalConstants.normalPersonSalary;

	public ManualWorker(City city,LocationPlanet locationPlanet) {
		super(new PeopleInitialConstants(populationInitial,foodUsePerPersonInitial,crimeRiskInitial,crimeImpactInitial,salaryInitial,city.getParentCountry(),locationPlanet), city);
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
		// TODO: 5/26/2016
		//workplace can be instance of industrial dock,
		//factory, dockyard, construction site
	}
}
