package engine.people.cityworkers;

import engine.buildings.workplaces.TownHall;
import engine.buildings.workplaces.Workplace;
import engine.planets.LocationPlanet;
import engine.universe.Country;
import engine.universe.UniversalConstants;

/*
    one ruler per country
*/
public class Ruler extends CityWorker implements Cloneable //TODO:clean this up
{
	public static int populationInitial = 1;
	public static double foodUsePerPersonInitial = UniversalConstants.normalFoodUsePerPerson;
	public static double crimeRiskInitial = 0.01*UniversalConstants.normalCrimeRisk;
	public static double crimeImpactInitial = 100.0*UniversalConstants.importantPersonCrimeImpact;
	public static double salaryInitial = 2.0*UniversalConstants.normalPersonSalary;
    //possible deprecation of this object//cannot be deprecated b/c ai
    private TownHall workplace;// TODO: 5/29/2016 long term mve this into city worker would be so much more convenient
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
		workplace = (TownHall) ruler.getWorkBuilding();
		registerContainer(workplace);// TODO: 5/29/2016 implent  remove
	}

	@Override
	protected void setWorkplace(Workplace workplace) {
		if(this.workplace != null)
			deregisterContainer(this.workplace);
		this.workplace = (TownHall) workplace;
		registerContainer(workplace);
	}

	@Override
    public Workplace getWorkBuilding() {
        return workplace;
    }

	//todo I have a setter now get rid of this
    @Override
    public void setWorkPlaceToNull() {
	    deregisterContainer(workplace);
		workplace = null;
    }

    @Override
    public void doSkill(double time) {
		//TODO unimplemented
        //needs to tie into ai and ui
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