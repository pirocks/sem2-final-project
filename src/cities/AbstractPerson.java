package cities;
import universe.UniqueId;
import cities.Building;

public abstract class AbstractPerson extends UniqueId
{
    protected int population;
    protected double foodUsePerPerson;//should be final
    protected double crimeRisk;//should be final
    protected double crimeImpact;//should be final
    protected double productivity;//should be final//unsure wether this is needed
    protected double wealth;
    protected City currentCity;
    protected Building home;
    public static enum Type
    {
        Ruler,Worker
    }
    protected Type type;
    abstract public void doSkill();//may need some args
}