package engine.people;

import engine.cities.Container;
import engine.people.cityworkers.PeopleInitialConstants;
import engine.planets.LocationPlanet;
import engine.tools.vehicles.Liver;
import engine.tools.vehicles.Path;
import engine.tools.vehicles.Vehicle;
import engine.tools.weapons.Attackable;
import engine.tools.weapons.Weapon;
import engine.universe.Country;
import engine.universe.UniversalConstants;

import java.util.ArrayList;

//this is not one soldier unit. It isd a unit of soldiers
//remember that
//how to do attacks???

public class Soldier extends AbstractPerson implements Container,Liver
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
	public static double speed = 10;

	public void setVehicle(Vehicle vehicle) {
		deregisterContainer(this.vehicle);
		this.vehicle = vehicle;
		registerContainer(vehicle);
	}

	public enum TypeOfTask {
        March,Drive,Guard,Heal//what about attack??
	}
	private Country parentCountry;

	private TypeOfTask currentTask;
	public static double healRate;
	public static double walkingSpeed;
	private Vehicle vehicle;
	private ArrayList<Weapon> weapons = new ArrayList<>();// TODO: 5/24/2016 soldiers need weapons and register
	private double xDestination,yDestination;
	public Soldier(Country parentCountry,LocationPlanet location) {
	    super(new PeopleInitialConstants(populationInitial, foodUsePerPersonInitial, crimeRiskInitial, crimeImpactInitial, salaryInitial, parentCountry,location));
		registerLiver();
	}

	private LocationPlanet Destination;
	private Path path;
	@Override
	public void doLife(double time) {
		switch(currentTask)
		{
			case March:
				if(getLocation().size() == 0)
					return;
				if(!getLocation().get(0).equals(path.getFirst())){
					try {
						getLocation().get(0).goTowards(path.getFirst(),speed,false,false,false);
					} catch (LocationPlanet.InTheOceanException e) {
						e.printStackTrace();
						throw new IllegalStateException();
					}
				}else{
					path.removeFirst();
					doLife(time);
				}
				break;
			case Drive:
				assert(vehicle != null);
				//assume vehicle has its orders
				break;
			case Heal:
                super.increaseHealth(healRate*time);
                if(super.getHealth() > 1.0)
                    super.setHealth(1);
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
    }
	@Override
	public void remove(Attackable attackable) {
		if(attackable instanceof Vehicle)
			remove((Vehicle) attackable);
		else
			throw new IllegalStateException();
	}
	private void remove(Vehicle vehicle) {
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