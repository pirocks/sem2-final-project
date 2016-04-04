


























package buildings;

import buildings.housing.ApartmentBlock;
import buildings.housing.RulersHouse;
import buildings.housing.WorkersHouseBlock;
import buildings.workplaces.*;
import cities.City;
import cities.CityBlock;
import people.AbstractPerson;
import planets.LocationPlanet;
import tools.weapons.Attackable;

/**
 * Created by bob on 3/5/2016.
 * does stuuff
 */
public abstract class Building implements Attackable //extends moneysource for workplace maybe??
{
    private double structuralIntegrity = 1.0;//form 0 to 1.0
    private double resistance;//the resistance as a 0 to 1.0 percentage
    
    // protected double costToBuild;//irrelevant
    // private double costToMaintain;//maybe get rid off or leave for later//leaving for later
    public static enum Type
    {
        ApartmentBlock,Factory,Hospital,IndustrialDock,ResearchArea,RulersHouse,School,TownHall,Warehouse,WorkersHouseBlock
    }
    private final boolean workplaceQ;
    private final boolean housingQ;
    protected CityBlock parentBlock;
    protected final Type type;//not necesary but whatever
    public Building(Type type,CityBlock parentBlock,boolean housingQ)
    {
        this.type = type;
        if(housingQ)
        {
            this.workplaceQ = false;
            this.housingQ = true;
        }
        else
        {
            this.workplaceQ = true;
            this.housingQ = false;
        }
        this.parentBlock = parentBlock;
        switch(type)
        {
            case ApartmentBlock:
                resistance = ApartmentBlock.resistanceInitial;
                break;
            case Factory:
                resistance = Factory.resistanceInitial;
                break;
            case Hospital:
                resistance = Hospital.resistanceInitial;
                break;
            case IndustrialDock:
                resistance = IndustrialDock.resistanceInitial;
                break;
            case ResearchArea:
                resistance = ResearchArea.resistanceInitial;
                break;
            case RulersHouse:
                resistance = RulersHouse.resistanceInitial;
                break;
            case School:
                resistance = School.resistanceInitial;
                break;
            case TownHall:
                resistance = TownHall.resistanceInitial;
                break;
            // case UniversitySection:
            //     resistance = UniversitySection.resistanceInitial;
            //     break;
            case Warehouse:
                resistance = Warehouse.resistanceInitial;
                break;
            // case WealthWorkersHouseBlock:
            //     resistance = WealthWorkersHouseBlock.resistanceInitial;
            //     break;
            case WorkersHouseBlock:
                resistance = WorkersHouseBlock.resistanceInitial;
                break;
            
        }
    }
    public City getParentCity()
    {
        return parentBlock.getParentCity();
    }
    public CityBlock getParentBlock()
    {
        return parentBlock;
    }
    public LocationPlanet getLocation()
    {
        return parentBlock.getLocation();
    }
    public Type getType() {
        return type;
    }
    public abstract void leavePerson(AbstractPerson person);
}
