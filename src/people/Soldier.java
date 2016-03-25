












package people;
import cities.City;
import cities.Building;
import cities.AbstractPerson;
import universe.UniversalConstants;
import planets.Country;

//this is not one soldier unit. It isd a unit of soldiers
//remeber that

public class Soldier extends AbstractPerson implements LocatablePlanet, LocatableUniverse
{
    public static enum TypeOfTask
    {
        March,Drive,Guard,Heal
    }
    private TypeOfTask currentTask;
    /*public???*/public static double healRate;//figure out the constants
    /*public?? constants figure out*/ public static double walkingSpeed;
    private Vehicle vehicle;
    private double MoneySource toGuard;
    private double xDestination,yDestination;
    
    public Soldier( City parentCity, Building home)
    {
		super(AbstractPerson.Type.WealthyWorker,parentCity,home);
    }
    public void doCurrentTask(long)
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
                break;
        }
    }
}