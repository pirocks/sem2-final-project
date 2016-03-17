package people;
import cities.City;
import cities.Building;
import cities.AbstractPerson;
import universe.UniversalConstants;
import planets.Country;
import universe.MoneySource;


public class Doctor extends AbstractPerson
{
    private static final long timeToHealOnePerson = 3600*24;
    public Doctor(Country parentCountry, City parentCity, Building home,MoneySource moneySource)
    {
        /*int population = 10;
        double health = 100.0;
        double foodUsePerPerson = UniversalConstants.normalFoodUsePerPerson;
        double crimeRisk = 0.5*UniversalConstants.normalCrimeRisk;
        double crimeImpact = 0.5*UniversalConstants.importantPersonCrimeImpact;
        double productivity = 1.0;//productivity from 0 to 1%
        double salary = UniversalConstants.doctorSalary;
        double wealth = UniversalConstants.defualtPersonStartWealth;
        City currentCity = parentCity;*/
        // Building home
        super(/*type*/AbstractPerson.Type.Doctor,
            /*population*/10,
            /*health*/100.0,
            /*foodUsePerPerson*/UniversalConstants.normalFoodUsePerPerson,
            /*crimeRisk*/0.5*UniversalConstants.normalCrimeRisk,
            /*crimeImpact*/0.5*UniversalConstants.importantPersonCrimeImpact,
            /*productivity*/1.0,
            /*salary*/UniversalConstants.doctorSalary,
            /*wealth*/UniversalConstants.defualtPersonStartWealth,
            /*currentCity*/parentCity,
            /*home*/home);//working on it
    }
    public void doSkillToPerson(AbstractPerson target,long time,MoneySource salaryGiver)//time is in seconds
    {
        //use productivity;
        double workDone = productivity*time/timeToHealOnePerson;
        int pop = target.getPopulation();
        double healthIncrease = workDone/((double)pop);
        if(100.0 - target.getHealth() > healthIncrease)
            healthIncrease = 100.0 - target.getHealth();
        target.increaseHealth(healthIncrease);
        salaryGiver.pay(this,salary*healthIncrease);
    }
    public void doSkillToBuilding(Building target,long time,MoneySource salaryGiver)
    {
        throw new IllegalArgumentException();
    }
    public boolean buildingAplicable()
    {
        return false;
    }
    public boolean personAplicable()
    {
        return true;
    }
}