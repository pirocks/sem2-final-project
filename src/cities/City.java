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
    private Grid parentGrid;
    private ArrayList<CityBlock> cityBlocks;
    public City()
    {
        
    }
}
