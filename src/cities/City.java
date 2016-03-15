package cities;
import java.util.ArrayList;
import universe.UniqueId;
import planets.LocatablePlanet;
import planets.Grid;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

/**
 * Created by bob on 3/5/2016.
 */

 
public class City extends UniqueId implements LocatablePlanet
{
    //remeber to add stuff to thhe unique id if I add more member vars
    //read the above comment
    private boolean isCapital;
    private double x,y;//center of city in grid
    private Grid parentGrid;//can be used to find location
    private ArrayList<CityBlock> cityBlocks;
    public City(boolean isCapital,Grid parentGrid, double x, double y)
    {
        if(x > 100.0 || x < 0.0)
            throw new IllegalArgumentException();
        if(y > 100.0 || y < 0.0)
            throw new IllegalArgumentException();
        this.isCapital = isCapital;
        this.x = x;
        this.y = y;
        this.parentGrid = parentGrid;
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
    public String toSaveString()
    {
        String cityBlocksArray = "";
        int i = 0;
        for(CityBlock item:cityBlocks)
        {
            cityBlocksArray += String.format("index%d %d",i,item.getId());
            i++;
        }
        return String.format("isCapital %d x %d y %d parentGrid %d cityBlocks[%s]",isCapital,x,y,parentGrid.getId(),cityBlocksArray);
    }
    public void loadFromSaveString(String in)
    {
        
    }
}
