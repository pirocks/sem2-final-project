package cities;
import universe.UniqueId;
import planets.LocatablePlanet;

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
