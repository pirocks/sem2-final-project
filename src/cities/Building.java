package cities;
import universe.UniqueId;
import java.util.ArrayList;
import planets.LocatablePlanet;

/**
 * Created by bob on 3/5/2016.
 */
public abstract class Building extends UniqueId implements LocatablePlanet
{
    private double x;//0,0 is top of grid
    private double y;
    protected double resistance;//resistance to damage
    protected double costToBuild;
    protected double costToMaintain;
    protected int maximumOccupancy;
    public static enum Type
    {
        ApartmentBlock,Factory,Hospital,IndustrialDock,ResearchArea,RulersHouse,School,TownHall,UniversitySection,Warehouse,WealthWorkersHouseBlock,WorkersHouseBlock
    }
    protected CityBlock parentBlock;
    protected Type type;
    protected ArrayList<AbstractPerson> residents;
    public Type getType()
    {
        return type;
    }
    public double getXInPlanet()
    {
        return parentBlock.getXInPlanet();
    }
    public double getYInPlanet()
    {
        return parentBlock.getYInPlanet();
    }
    public boolean overcrowdedQ()
    {
        int sum = 0;
        for(AbstractPerson person:residents)
            sum += person.getPopulation();
        if(sum > maximumOccupancy)
            return false;
        return true;
    }
}
