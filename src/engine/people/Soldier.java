package engine.people;

import engine.people.cityworkers.PeopleInitialConstants;
import engine.planets.LocationPlanet;
import engine.universe.Country;
import engine.tools.vehicles.Vehicle;
import engine.tools.vehicles.VehicleContainer;
import engine.tools.weapons.Weapon;
import engine.universe.MoneySource;
import engine.universe.MoneySourceContainer;
import engine.universe.UniversalConstants;

//this is not one soldier unit. It isd a unit of soldiers
//remember that
//how to do attacks???

public class Soldier extends AbstractPerson implements VehicleContainer, MoneySourceContainer
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
    /*public???*/public static double healRate;//figure out the constants
    /*public?? constants figure out*/ public static double walkingSpeed;
    private Vehicle vehicle;
    private MoneySource toGuard;
    private double xDestination,yDestination;
    public Soldier(Country parentCountry) {
	    //todo what about location here
	    super(new PeopleInitialConstants(populationInitial,
			    foodUsePerPersonInitial,
			    crimeRiskInitial,
			    crimeImpactInitial,
			    salaryInitial,
			    parentCountry));

	    registerVehicleContainer();
	    registerMoneySourceContainer();
    }

	// TODO: 4/10/2016 implment do skill and figure out hjow the soldsier do skill worrks/asking for new orders?
	public void doSkill(long time) {
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
                attackableConstants.health += healRate*time;
                if(attackableConstants.health > 1.0)
                    attackableConstants.health = 1.0;
                break;
        }
        salaryGiver.pay(this,time*getSalary());
    }
    @Override
    protected void dieSpecific()
    {
		return;
    }//TODO:implement this
	@Override
	public void remove(Country country,Country conqueror) {
		if(parentCountry == country)
		{
			parentCountry = conqueror;//// TODO: 4/10/2016 register as citizen etc in country
			assert (false);
		}
	}
	@Override
	public void remove(Vehicle vehicle) {
		if(this.vehicle == vehicle)
		{
			die();
			vehicle = null;
		}
	}
	@Override
	public void remove(MoneySource in) {
		if(in == toGuard)
			toGuard = null;
		if(parentCountry == in)
			remove(parentCountry);
	}
	@Override
	public double getWeight() {
		return 0;// TODO: 4/9/2016
	}

}