package people;

import buildings.Building;
import cities.City;
import planets.Country;
import planets.LocationPlanet;
import tools.weapons.Attackable;
import universe.MoneySource;
import universe.UniversalConstants;

public abstract class AbstractPerson extends MoneySource implements Attackable
{
	public static double personDamageResistance;
	protected LocationPlanet location;
    public AbstractPerson(Type type, City parentCity, Building home) {
        this(type,parentCity.getParentCountry());
    }

    //might need to add checks for health or population below 0;
    public static enum Type
    {
        Doctor,Researcher,Ruler,Soldier,Teacher,WealthyWorker, Bureaucrat, Worker
    }
    // deprecated b/c location private Grid currentGrid;
    protected final Country country;//final??
    // deprecated b/c location protected double x,y;//okay if inacurate as long as in city//mostly for use of soldiers//in grid
    private final Type type;
    private int population;
    protected double health;//100% is fully healthy, 0% is dead from 0 to 1.0
    private double foodUsePerPerson;//should be final
    private double crimeRisk;//should be final
    private double crimeImpact;//should be final
    protected double productivity;//should be final//unsure wether this is needed
    protected double salary;
    protected boolean employedq;
    protected MoneySource salaryGiver;//needs to be set when assigned
    public AbstractPerson(Type type,Country country)
    {
        super(Double.NaN);
        double corruptionFactor = UniversalConstants.getCorruptionFactor(country);
        int population;
        double health = 1.0;//a percent//inited
        double foodUsePerPerson = UniversalConstants.normalFoodUsePerPerson;//inited
        double crimeRisk = UniversalConstants.normalCrimeRisk;//inited//a percent
        double crimeImpact;//inited//a money amount
        double productivity = 1.0;//inited//a percent//productivity can be changed by constants editor
        double salary;//inited//a money amount
        double wealth = UniversalConstants.defualtPersonStartWealth;//inited
        switch(type)
        {
            case Doctor:
                salary = 2.0*UniversalConstants.normalPersonSalary;
                population = 100;//magic number fixes
                crimeImpact = UniversalConstants.importantPersonCrimeImpact;
                break;
            case Researcher:
                salary = 2.0*UniversalConstants.normalPersonSalary;
                population = 100;
                crimeImpact = UniversalConstants.importantPersonCrimeImpact;
                break;
            case Ruler:
                population = 1;
                salary = 2.0*corruptionFactor*UniversalConstants.normalPersonSalary;
                crimeRisk = 0.01*UniversalConstants.normalCrimeRisk;
                foodUsePerPerson = corruptionFactor*10.0*UniversalConstants.normalFoodUsePerPerson;
                crimeImpact = 100.0*UniversalConstants.importantPersonCrimeImpact;
                break;
            case Soldier:
                salary = UniversalConstants.normalPersonSalary;
                population = 5000;// a unit of soldiers
                crimeImpact = 0.5*UniversalConstants.importantPersonCrimeImpact;
                break;
            case Teacher:
                salary = UniversalConstants.normalPersonSalary;
                population = 250;
                crimeImpact = UniversalConstants.normalPersonCrimeImpact;
                break;
            case WealthyWorker:
                salary = 2.0*UniversalConstants.normalPersonSalary;
                population = 500;
                crimeImpact = 5.0*UniversalConstants.normalPersonCrimeImpact;
                break;
            case Worker:
                salary = UniversalConstants.normalPersonSalary;
                population = 1000;
                crimeImpact = UniversalConstants.normalPersonCrimeImpact;
                break;
            default:
                assert(false);
                throw new IllegalStateException();
        }
        // this(type,population,health,foodUsePerPerson,crimeRisk,crimeImpact,productivity,salary,wealth,currentCity,home);
        super.setWealth(wealth);
        this.type = type;
        this.salaryGiver = salaryGiver; 
        this.population = population;
        this.health = health;
        this.foodUsePerPerson = foodUsePerPerson;
        this.crimeRisk = crimeRisk;
        this.crimeImpact = crimeImpact;
        this.productivity = productivity;
        this.salary = salary;
        this.country = country;
        // this.currentCity = currentCity;
        // this.home = home;

    }
    public double getHealth()
    {
        return health;
    }
    public void increaseHealth(double amount)
    {
        assert(amount <= 1.0 - health);
        health += amount;
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
    @Override
	public void recieveDamage(double damage)
    {
	    health = (health*personDamageResistance - damage)/personDamageResistance;
	    amIDead();
    }
	private boolean alliveQ;
	public boolean amIDead()
	{
		if(population <= 0)
			die();
		if(health <= 0)
			die();
		return alliveQ;
	}
	public void die()
	{
		alliveQ = false;
		dieSpecific();
		leaveCountryForDeath();

		//need to delete all refernces to this object
	}
	protected abstract void dieSpecific();
	public void leaveCountryForDeath()
	{
		country.loosePerson(this);
	}
}