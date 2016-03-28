package cities;
import universe.*;
import java.util.ArrayList;
import planets.*;
import people.*;

/**
 * Created by bob on 3/5/2016.
 */
public abstract class Building implements LocatablePlanet
{
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
    protected ArrayList<CityWorker> residents;
    public City getParentCity()
    {
        return parentBlock.getParentCity();
    }
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
        int sum = getPopulation();
        if(sum > maximumOccupancy)
            return false;
        return true;
    }
    public int getPopulation()
    {
        int sum = 0;
        for(CityWorker person:residents)
            sum += person.getPopulation();
        return sum;
    }
    public Grid getGrid()
    {
        return parentBlock.getGrid();
    }
    public int getXInGrid()
    {
        return parentBlock.getXInGrid();//do no change this without first fixing cityworker.distancebetweenbuildins
    }
    public int getYInGrid()
    {
        return parentBlock.getYInGrid();
    }
}
