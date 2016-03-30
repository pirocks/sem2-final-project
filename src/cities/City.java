package cities;
import java.util.ArrayList;
import universe.UniqueId;
import planets.LocatablePlanet;
import planets.Grid;
import universe.MoneySource;
import buildings.*;
import planets.Country;
// import org.w3c.dom.*;
// import javax.xml.parsers.*;
// import java.io.*;

/**
 * Created by bob on 3/5/2016.
 */

 
public class City extends MoneySource implements LocatablePlanet
{
    //remeber to add stuff to thhe unique id if I add more member vars
    //read the above comment
    private boolean isCapital;
    private int x,y;//center of city in grid//will be townhall locatiuon
    private Grid parentGrid;//can be used to find location//cities limited to one grid
    private ArrayList<CityBlock> cityBlocks;
    private ArrayList<Hospital> hospitals;
    public ArrayList<CityWorker> residents;
    public ArrayList<CityWorker> unemployedResidents;
    private Country parentCountry;//make sutre to change when cuity is captured.
    public City(boolean isCapital,Grid parentGrid,Country parentCountry,double wealth, int x, int y)
    {
        super(wealth);
        if(x > 100 || x < 0)
            throw new IllegalArgumentException();
        if(y > 100 || y < 0)
            throw new IllegalArgumentException();
        this.isCapital = isCapital;
        this.x = x;
        this.y = y;
        this.parentGrid = parentGrid;
        this.parentCountry = parentCountry;
    }
    public ArrayList<CityBlock> getCityBlocks()
    {
        return cityBlocks;
    }
    public Building getCapitalBuilding()
    {
        assert(isCapital);
        for(CityBlock cityBlock:cityBlocks)
            if(cityBlock.getBuilding().getType() == Building.Type.RulersHouse)
                return cityBlock.getBuilding();
        assert(false);
        return null;
    }
    public double getXInPlanet()
    {
        double GridX = (double)parentGrid.getX();
        return GridX + x/100.0;
    }
    public double getYInPlanet()
    {
        double GridY = (double)parentGrid.getY();
        return GridY + y/100.0;
    }
    public Country getParentCountry()
    {
        return parentCountry;
    }
    public Grid getGrid()
    {
        return parentGrid;
    }
    public double getXInGrid()
    {
        return x;
    }
    public double getYInGrid()
    {
        return y;
    }
    public Hospital getLeastLoadedHosital()
    {
        Hospital leastLoadedHospital = hospitals.get(0);
        for(Hospital hospital:hospitals)
            if(leastLoadedHospital.getWorkLoad() > hospital.getWorkLoad())
                leastLoadedHospital = hospital;
        return leastLoadedHospital;
    }

}
