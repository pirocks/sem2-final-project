package cities;
import universe.UniqueId;
import cities.Building;
import universe.MoneySource;

public abstract class AbstractPerson extends MoneySource
{
    //might need to add checls for health or population below 0;
    public static enum Type
    {
        Doctor,Researcher,Ruler,Soldier,Teacher,WealthyWorker,Worker
    }
    protected Type type;
    protected int population;
    protected double health;//100% is fully healthy, 0% is dead from 0 to 1.0
    protected double foodUsePerPerson;//should be final
    protected double crimeRisk;//should be final
    protected double crimeImpact;//should be final
    protected double productivity;//should be final//unsure wether this is needed
    protected double salary;
    protected City currentCity;
    protected Building home;
    private AbstractPerson(Type type,int population,double health,double foodUsePerPerson,double crimeRisk,double crimeImpact,double productivity,double salary,double wealth,City currentCity,Building home)
    {
        super(wealth);
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
    public AbstractPerson(Type type,City currentCity,Building home)
    {
        double corruptionFactor = UniversalConstants.getCorruptionFactor(currentCity.getParentCountry().getGovermentType());
        int population;
        double health = 1.0;//a percent//inited
        double foodUsePerPerson = UniversalConstants.normalFoodUsePerPerson;//inited
        double crimeRisk = UniversalConstants.normalCrimeRisk;//inited//a percent
        double crimeImpact;//inited//a money amount
        double productivity = 1.0;//inited//a percent//productivity can be changed by constants editor
        double salary;//a money amount
        double wealth = UniversalConstants.defualtPersonStartWealth;
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
                population = 500;
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
    abstract public void doSkillToPerson(AbstractPerson target,long time,MoneySource salaryGiver);//secondary target is for supplies
    abstract public void doSkillToBuilding(Building target,long time,MoneySource salaryGiver);
    abstract public boolean buildingAplicable();
    abstract public boolean personAplicable();
    public int getPopulation()
    {
        return population;
    }
}