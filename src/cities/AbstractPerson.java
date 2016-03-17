package cities;
import universe.UniqueId;
import cities.Building;
import universe.MoneySource;

public abstract class AbstractPerson extends MoneySource
{
    //abstranstructor for all this shit maybe?????
    //might need to add checls for health or population below 0;
    protected Type type;
    protected int population;
    protected double health;//100% is fully healthy, 0% is dead
    protected double foodUsePerPerson;//should be final
    protected double crimeRisk;//should be final
    protected double crimeImpact;//should be final
    protected double productivity;//should be final//unsure wether this is needed
    protected double salary;
    protected City currentCity;
    protected Building home;
    public AbstractPerson(Type type,
        int population,
        double health,
        double foodUsePerPerson,
        double crimeRisk,
        double crimeImpact,
        double productivity,
        double salary,
        City currentCity,
        Building home)
    {
        this.type = type;
        this.population = population;
        this.health = health;
        this.foodUsePerPerson = foodUsePerPerson;
        this.crimeRisk = crimeRisk;
        this.crimeImpact = crimeImpact;
        this.productivity = productivity;
        this.salary = salary;
        this.currentCity = currentCity;
        this.home = home;
    }
    public double getHealth()
    {
        return health;
    }
    public void increaseHealth(double amount)
    {
        assert(amount <= 100.0 - health);
        health += amount;
    }
    public static enum Type
    {
        Ruler,Worker,Researcher
    }
    abstract public void doSkillToPerson(AbstractPerson target,long time,MoneySource salaryGiver);//secondary target is for supplies
    abstract public void doSkillToBuilding(Building target,long time,MoneySource salaryGiver);
    abstract public boolean buildingAplicable();
    abstract public boolean personAplicable();
    public int getPopulation()
    {
        return population;
    }
}