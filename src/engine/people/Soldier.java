package engine.people;

import engine.planets.Country;
import engine.tools.vehicles.Vehicle;
import engine.tools.vehicles.VehicleContainer;
import engine.tools.weapons.Weapon;
import engine.universe.MoneySource;
import engine.universe.MoneySourceContainer;

//this is not one soldier unit. It isd a unit of soldiers
//remember that
//how to do attacks???

public class Soldier extends AbstractPerson implements VehicleContainer, MoneySourceContainer
{
    @Override
    public void remove(Country country) {
        if(parentCountry == country)
        {
	        parentCountry = null;
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
    @Override//TODO: implement this
    public boolean receiveDamage(double damage, Weapon attacker) {

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

	public static enum TypeOfTask
    {
        March,Drive,Guard,Heal//what about attack??
    };
    private Country parentCountry;
    private TypeOfTask currentTask;
    /*public???*/public static double healRate;//figure out the constants
    /*public?? constants figure out*/ public static double walkingSpeed;
    private Vehicle vehicle;
    private MoneySource toGuard;
    private double xDestination,yDestination;
    public Soldier(Country parentCountry)
    {
	    //todo what about location here
	    super(AbstractPerson.Type.WealthyWorker,parentCountry);
	    registerVehicleContainer();
	    registerMoneySourceContainer();
    }
    public void doSkill(long time)
    {
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
                health += healRate*time;
                if(health > 1.0)
                    health = 1.0;
                break;
        }
        salaryGiver.pay(this,time*salary);
    }
    @Override
    protected void dieSpecific()
    {
		return;
    }//TODO:implement this
}