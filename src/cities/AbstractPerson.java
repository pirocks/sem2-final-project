package cities;
import universe.UniqueId;
import cities.Building;

public abstract class AbstractPerson extends UniqueId
{
    protected int population;
    protected final double foodUsePerPerson;
    protected final double crimeRisk;
    protected final double crimeImpact;
    protected final double productivity;//unsure wether this is needed
    protected double wealth;
    protected City currentCity;
    protected Building home;
    public static enum Type
    {
        Ruler,
    }
    protected Type type;
    abstract public void doSkill();//may need some args
}