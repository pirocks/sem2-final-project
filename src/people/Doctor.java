















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
    private MoneySource salaryGiver;
    private AbstractPerson sickPerson;
    public Doctor(City parentCity, Building home)
    {
        super(AbstractPerson.Type.Doctor,parentCity,home);
    }
    public void setPerson(AbstractPerson person)
    {
        sickPerson = person;
    }
    public void doSkill(long time)//time is in seconds
    {
        //use productivity;
        //not sure if this is good yet
        AbstractPerson target = sickPerson;//mybe make this an array or city
        double workDone = productivity*time/timeToHealOnePerson;
        int pop = target.getPopulation();
        double healthIncrease = workDone/((double)pop);
        if(100.0 - target.getHealth() > healthIncrease)
            healthIncrease = 100.0 - target.getHealth();
        if(salaryGiver.canPay(salary*healthIncrease))
        {    
            target.increaseHealth(healthIncrease);
            salaryGiver.pay(this,salary*healthIncrease);
        }
        else
        {
            salaryGiver.outOfMoneyHandler(salary*healthIncrease);
        }
    }
    public void doCurrentTask(long time)
    {
        doSkill(time);
    }
}