package cities;
import universe.UniqueId;
import java.util.ArrayList;
import planets.LocatablePlanet;

/**
 * Created by bob on 3/5/2016.
 */
public abstract class Building extends UniqueId implements LocatablePlanet
{
    private double resistance;//resistance to damage
    private double costToBuild;
    private double costToMaintain;
    private int maximumOccupancy;
    public enum Type
    {
        
    }
    private CityBlock parentBlock;
    private Type type;
    private ArrayList<AbstractPerson> residents;
}
