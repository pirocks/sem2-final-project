












package people;

import planets.*;
import universe.*;
import cities.*;
import tools.vehicles.Vehicle;

//this is not one soldier unit. It isd a unit of soldiers
//remeber that

public class Soldier extends AbstractPerson implements LocatablePlanet/*, LocatableUniverse*/
{

    public static enum TypeOfTask
    {
        March,Drive,Guard,Heal//what about attack??
    };
    private TypeOfTask currentTask;
    /*public???*/public static double healRate;//figure out the constants
    /*public?? constants figure out*/ public static double walkingSpeed;
    private Vehicle vehicle;
    private MoneySource toGuard;
    private double xDestination,yDestination;
    
    public Soldier(Country parentCountry)
    {
        //what about location here
		super(AbstractPerson.Type.WealthyWorker,parentCountry);
    }
    public void doSkill(long time)
    {
        switch(currentTask)
        {
            case March:
                
                break;
            case Drive:
                assert(vehicle != null);
                
                break;
            case Guard:
                
                break;
            case Heal:
                health += healRate*time;
                if(health > 1.0)
                    health = 1.0;
                salaryGiver.pay(this,time*salary);
                break;
        }
    }
}