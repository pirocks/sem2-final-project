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
        //todo constructor
        
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