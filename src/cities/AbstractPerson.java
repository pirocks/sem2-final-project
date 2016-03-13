package cities;
import universe.UniqueId;
import cities.Building;

public abstract class AbstractPerson extends UniqueId
{
    private int population;
    private final double foodUsePerPerson;
    private final double crimeRisk;
    private final double crimeImpact
    private final double productivity;//unsure wether this is needed
    private double wealth;
    private City currentCity;
    private Building home;
    public enum Type
    {
        Ruler,
    }
    private Type type;
    abstract public void doSkill();//may need some args
}