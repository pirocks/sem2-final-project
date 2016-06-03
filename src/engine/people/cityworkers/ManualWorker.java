package engine.people.cityworkers;

import engine.buildings.UnderConstruction;
import engine.buildings.workplaces.ToolBuilder;
import engine.buildings.workplaces.Warehouse;
import engine.cities.City;
import engine.planets.LocationPlanet;
import engine.universe.Resource;
import engine.universe.UniversalConstants;

/**
 * Created by bob on 5/26/2016.
 *
 */
public class ManualWorker extends CityWorker
{
	public static int populationInitial = 1000;
	public static double foodUsePerPersonInitial = UniversalConstants.normalFoodUsePerPerson;
	public static double crimeRiskInitial = UniversalConstants.normalCrimeRisk;
	public static double crimeImpactInitial = UniversalConstants.normalPersonCrimeImpact;
	public static double salaryInitial = UniversalConstants.normalPersonSalary;

	public ManualWorker(City city,LocationPlanet locationPlanet) {
		super(new PeopleInitialConstants(populationInitial,foodUsePerPersonInitial,crimeRiskInitial,crimeImpactInitial,salaryInitial,city.getParentCountry(),locationPlanet), city);
		if(locationPlanet == null)
			throw new IllegalArgumentException();
	}
	private ManualWorker(ManualWorker manualWorker){
		super(manualWorker);
	}
	@Override
	public void doSkill(double time) {
		//workplace can be instance of industrial dock,
		//factory, dockyard, construction site
		if(getWorkBuilding() instanceof ToolBuilder){
			ToolBuilder workplace = (ToolBuilder)getWorkBuilding();
			workplace.makeProgress(time*getPopulation());
		}
		else if(getWorkBuilding() instanceof UnderConstruction){
			UnderConstruction workplace = (UnderConstruction) getWorkBuilding();
			workplace.makeProgress(time*getPopulation());
		}
		else if(getWorkBuilding() instanceof Warehouse){
			((Warehouse)getWorkBuilding()).updateMaxWeight();
			try {
				((Warehouse)getWorkBuilding()).addInStock(new Resource(new Resource.Type[]{Resource.Type.Iron,Resource.Type.Oil,Resource.Type.Uranium,Resource.Type.Helium,Resource.Type.Food,Resource.Type.Water,Resource.Type.Wood,Resource.Type.Silicon},new Double[] {1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0}));
			} catch (ToHeavyException e) {
				e.printStackTrace();
			}
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
