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
    private double resistance;//actually the structural uintegrity of the buiding. Change name and refactor with intelij
    // protected double costToBuild;//irrelevant
    private double costToMaintain;
    public static enum Type
    {
        ApartmentBlock,Factory,Hospital,IndustrialDock,ResearchArea,RulersHouse,School,TownHall,UniversitySection,Warehouse,WealthWorkersHouseBlock,WorkersHouseBlock
    }
    protected CityBlock parentBlock;
    // protected Type type;
    protected ArrayList<CityWorker> residents;
    public Building(Type type,CityBlock parentBlock,ArrayList<CityWorker> residents)
    {
        this.residents = residents;
        this.parentBlock = parentBlock;
        switch(type)
        {
            case ApartmentBlock:
                resistance = ;
                costToMaintain = ;
                maximumOccupancy = ;
                break;
            case Factory:
                resistance = ;
                costToMaintain = ;
                maximumOccupancy = ;
                break;
            case Hospital:
                resistance = ;
                costToMaintain = ;
                maximumOccupancy = ;
                break;
            case IndustrialDock:
                resistance = ;
                costToMaintain = ;
                maximumOccupancy = ;
                break;
            case ResearchArea:
                resistance = ;
                costToMaintain = ;
                maximumOccupancy = ;
                break;
            case RulersHouse:
                resistance = ;
                costToMaintain = ;
                maximumOccupancy = ;
                break;
            case School:
                resistance = ;
                costToMaintain = ;
                maximumOccupancy = ;
                break;
            case TownHall:
                resistance = ;
                costToMaintain = ;
                maximumOccupancy = ;
                break;
            case UniversitySection:
                resistance = ;
                costToMaintain = ;
                maximumOccupancy = ;
                break;
            case Warehouse:
                resistance = ;
                costToMaintain = ;
                maximumOccupancy = ;
                break;
            case WealthWorkersHouseBlock:
                resistance = ;
                costToMaintain = ;
                maximumOccupancy = ;
                break;
            case WorkersHouseBlock:
                resistance = ;
                costToMaintain = ;
                maximumOccupancy = ;
                break;
            
        }
    }
    public City getParentCity()
    {
        return parentBlock.getParentCity();
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
