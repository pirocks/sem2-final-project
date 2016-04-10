package engine.people;

import engine.buildings.Building;
import engine.cities.City;
import engine.people.cityworkers.*;
//import engine.people.cityworkers.Researcher;
//import engine.people.cityworkers.Ruler;
//import engine.people.cityworkers.Teacher;
import engine.universe.Country;
import engine.universe.CountryContainer;
import engine.planets.LocationPlanet;
import engine.tools.AttackableConstants;
import engine.tools.vehicles.Weighable;
import engine.tools.weapons.Attackable;
import engine.universe.MoneySource;
import engine.universe.MoneySourceContainer;
import engine.universe.UniversalConstants;

public abstract class AbstractPerson extends MoneySource implements Attackable, CountryContainer, MoneySourceContainer,Weighable
{
	public static double resistanceInitial;
	public static double healthInitial;
	public AttackableConstants attackableConstants;
	protected LocationPlanet location;
	//might need to add checks for health or population below 0;
	// deprecated b/c location private Grid currentGrid;
	protected Country country;//final??
	private int population;
	private double foodUsePerPerson;//should be final
	private double crimeRisk;//should be final
	private double crimeImpact;//should be final
	protected double salary;
	protected boolean employedq;
	protected MoneySource salaryGiver;//needs to be set when assigned

    public AbstractPerson(City parentCity, Building home) {
        this(parentCity.getParentCountry());
    }
    public AbstractPerson(Country country) {
	    super(Double.NaN);
	    registerCountryContainer();
	    registerMoneySourceContainer();
	    double corruptionFactor = UniversalConstants.getCorruptionFactor(country);
	    int population = 0;
	    double health = 1.0;//a percent//inited
	    double foodUsePerPerson = UniversalConstants.normalFoodUsePerPerson;//inited
	    double crimeRisk = UniversalConstants.normalCrimeRisk;//inited//a percent
	    double crimeImpact = 0;//inited//a money amount
	    double salary = 0;//inited//a money amount
	    double wealth = UniversalConstants.defualtPersonStartWealth;//inited
	    if(this instanceof Doctor)
		{
			salary = 2.0 * UniversalConstants.normalPersonSalary;
			population = 100;//magic number fixes
			crimeImpact = UniversalConstants.importantPersonCrimeImpact;
		}
        else if(this instanceof Researcher)
		{
			salary = 2.0 * UniversalConstants.normalPersonSalary;
			population = 100;
			crimeImpact = UniversalConstants.importantPersonCrimeImpact;
		}
        else if(this instanceof Ruler)
		{
			population = 1;
			salary = 2.0 * corruptionFactor * UniversalConstants.normalPersonSalary;
			crimeRisk = 0.01 * UniversalConstants.normalCrimeRisk;
			foodUsePerPerson = corruptionFactor * 10.0 * UniversalConstants.normalFoodUsePerPerson;
			crimeImpact = 100.0 * UniversalConstants.importantPersonCrimeImpact;
		}
        else if(this instanceof Soldier)
		{
			salary = UniversalConstants.normalPersonSalary;
			population = 5000;// a unit of soldiers
			crimeImpact = 0.5 * UniversalConstants.importantPersonCrimeImpact;
		}
        else if(this instanceof Teacher)
		{
			salary = UniversalConstants.normalPersonSalary;
			population = 250;
			crimeImpact = UniversalConstants.normalPersonCrimeImpact;
		}
//        if(this instanceof WealthyWorker)
//	{
//		salary = 2.0 * UniversalConstants.normalPersonSalary;
//		population = 500;
//		crimeImpact = 5.0 * UniversalConstants.normalPersonCrimeImpact;
//	}
        else if(this instanceof Worker)
		{
			salary = UniversalConstants.normalPersonSalary;
			population = 1000;
			crimeImpact = UniversalConstants.normalPersonCrimeImpact;
		}
	    else
	    {
		    assert (false);
	    }
        // this(type,population,health,foodUsePerPerson,crimeRisk,crimeImpact,productivity,salary,wealth,currentCity,home);
        super.setWealth(wealth);
	    this.salaryGiver = salaryGiver;
        this.population = population;
        attackableConstants.health = health;
        this.foodUsePerPerson = foodUsePerPerson;
        this.crimeRisk = crimeRisk;
        this.crimeImpact = crimeImpact;
        this.salary = salary;
        this.country = country;
    }
    public double getHealth()
    {
        return attackableConstants.health;
    }
    public void increaseHealth(double amount) {
        assert(amount <= 1.0 - attackableConstants.health);
        attackableConstants.health += amount;
    }
    public abstract void doSkill(long time);//I don't thinksalary is required
    public int getPopulation()
    {
        return population;
    }
    public LocationPlanet getLocation()
    {
        return location;
    }
	private boolean alliveQ;
	public boolean amIDead() {
		if(population <= 0)
			die();
		if(attackableConstants.health <= 0)
			die();
		return alliveQ;
	}
	public void die() {
		alliveQ = false;
		dieSpecific();
		leaveCountryForDeath();
		//need to delete all refernces to this object
	}
	protected abstract void dieSpecific();
	@Deprecated
	public void leaveCountryForDeath()
	{
		country.loosePerson(this);
	}
	@Override
	//TODO://how do the countryless work//they don't work/exsist
	//if a country is destroyed they switch over to the destroyer
	public void remove(Country country,Country conqueror) {
		if(country == this.country)
			this.country = conqueror;// TODO: 4/10/2016 register a citizen and go through and fix that everywhere
	}
	@Override
	public void remove(MoneySource moneySource) {
		if(salaryGiver == moneySource)
			salaryGiver = null;
	}
	@Override
	public boolean receiveDamage(double damage) {
		return attackableConstants.receiveDamage(damage,this);
	}
	@Override
	public LocationPlanet getLocationPlanet() {
		return location;
	}
}