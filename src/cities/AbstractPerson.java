package cities;
import universe.UniqueId;

abstract class AbstractPerson extends UniqueId
{
    private  int population;
    private final  double foodUsePerPerson;
    private final  double crimeRisk;
    private final  double productivity;
    private  double wealth;
    private City currentCity;
    private Building home;
    public enum Skill
    {
        
    }
    private Skill skill;
    abstract public void doSkill();//may need some args
    abstract public AbstractPerson();
}