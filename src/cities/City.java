package cities;
import java.util.ArrayList;
import universe.UniqueId;
import planets.LocatablePlanet;
import planets.Grid;

/**
 * Created by bob on 3/5/2016.
 */

 
public class City extends UniqueId implements LocatablePlanet
{
    private boolean isCapital;
    private double x,y;//center of city in grid
    private Grid parentGrid;//can be used to find location
    private ArrayList<CityBlock> cityBlocks;
    public City()
    {
        
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
}
