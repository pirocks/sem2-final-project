package engine.people.cityworkers;

import engine.buildings.UnderConstruction;
import engine.buildings.workplaces.ToolBuilder;
import engine.buildings.workplaces.Workplace;
import engine.cities.City;
import engine.planets.LocationPlanet;
import engine.universe.UniversalConstants;

/**
 * Created by bob on 5/26/2016.
 *
 */
public class ManualWorker extends CityWorker implements Cloneable
{
	private Workplace workplace;
	public static int populationInitial = 1000;
	public static double foodUsePerPersonInitial = UniversalConstants.normalFoodUsePerPerson;
	public static double crimeRiskInitial = UniversalConstants.normalCrimeRisk;
	public static double crimeImpactInitial = UniversalConstants.normalPersonCrimeImpact;
	public static double salaryInitial = UniversalConstants.normalPersonSalary;

	public ManualWorker(City city,LocationPlanet locationPlanet) {
		super(new PeopleInitialConstants(populationInitial,foodUsePerPersonInitial,crimeRiskInitial,crimeImpactInitial,salaryInitial,city.getParentCountry(),locationPlanet), city);
	}
	private ManualWorker(ManualWorker manualWorker){
		super(manualWorker);
		workplace = manualWorker.getWorkBuilding();
		registerContainer(workplace);// TODO: 5/29/2016 implment remove
	}
	@Override
	protected void setWorkplace(Workplace workplace) {
		this.workplace = workplace;
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
	public void doSkill(double time) {
		//workplace can be instance of industrial dock,
		//factory, dockyard, construction site
		if(workplace  instanceof ToolBuilder){
			ToolBuilder workplace = (ToolBuilder)this.workplace;
			workplace.makeProgress(time*getPopulation());
		}
		else if(workplace instanceof UnderConstruction){
			UnderConstruction workplace = (UnderConstruction) this.workplace;
			workplace.makeProgress(time*getPopulation());
		}
		else
			throw new IllegalStateException();
		paySalary(time);
	}
	@Override
	protected CityWorker splitInternal() {
		return new ManualWorker(this);
	}
}
