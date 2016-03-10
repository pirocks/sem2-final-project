package cities;

abstract class AbstractPerson extends UniqueId
{
    private abstract int population;
    private final abstract double foodUsePerPerson;
    private final abstract double crimeRisk;
    private final abstract double productivity;
    private abstract double wealth;
    private City currentCity;
    private Building home;
    public enum Skill
    {
        
    }
    private Skill skill;
    abstract public void doSkill();//may need some args
    abstract public AbstractPerson();
}