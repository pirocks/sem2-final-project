package engine.people;

import engine.cities.Container;
import engine.people.cityworkers.PeopleInitialConstants;
import engine.planets.LocationPlanet;
import engine.tools.vehicles.Vehicle;
import engine.tools.weapons.Attackable;
import engine.universe.Country;
import engine.universe.MoneySource;
import engine.universe.UniversalConstants;

//this is not one soldier unit. It isd a unit of soldiers
//remember that
//how to do attacks???

public class Soldier extends AbstractPerson implements Container,Cloneable
{
	public static int populationInitial = 5000;
	public static double foodUsePerPersonInitial =
			UniversalConstants.normalFoodUsePerPerson;
	public static double crimeRiskInitial =
			UniversalConstants.normalCrimeRisk;
	public static double crimeImpactInitial =
			0.5*UniversalConstants.importantPersonCrimeImpact;
	public static double salaryInitial =
			UniversalConstants.normalPersonSalary;
	private static long timeToHealOnePerson = 3600*24;
	public enum TypeOfTask {
        March,Drive,Guard,Heal//what about attack??
	}
	private Country parentCountry;

	private TypeOfTask currentTask;
	public static double healRate;
	public static double walkingSpeed;
	private Vehicle vehicle;// TODO: 5/24/2016 register this with the container
	// TODO: 5/24/2016 soldiers need weapons
	private MoneySource toGuard;
	private double xDestination,yDestination;
	public Soldier(Country parentCountry,LocationPlanet location) {
	    //todo what about location here
	    super(new PeopleInitialConstants(populationInitial, foodUsePerPersonInitial, crimeRiskInitial, crimeImpactInitial, salaryInitial, parentCountry,location));
	}

	// TODO: 4/10/2016 implement do life and figure out hjow the soldsier do skill worrks/asking for new orders?
	@Override
	public void doLife(double time) {
		switch(currentTask)
		{
			case March:
				//how are estinations represented??
				//location objects??
				break;
			case Drive:
				assert(vehicle != null);
				//??vehicle.drive(time);/////?????
				break;
			case Guard:
				//moneysources could move very fast??
				//how does this work
				break;
			case Heal:
				// TODO: 5/5/2016 update to use attackable constants
//                attackableConstants.health += healRate*time;
//                if(attackableConstants.health > 1.0)
//                    attackableConstants.health = 1.0;
				break;
		}
		paySalary(time);
	}

	@Override
	public boolean sanityCheck() {
		super.sanityCheck();
		return true;
	}
	@Override
    protected void dieSpecific()
    {
		return;
    }//TODO:implement this
	@Override
	public void remove(Attackable attackable) {
		if(attackable instanceof Vehicle)
			remove((Vehicle) attackable);
		else
			throw new IllegalStateException();
	}
	public void remove(Vehicle vehicle) {
		if(this.vehicle == vehicle) {
			die();
			vehicle = null;
		}
	}
	@Override
	public double getWeight() {
		return 1;
	}

}