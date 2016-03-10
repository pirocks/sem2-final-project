package planets;

/**
 * Created by bob on 3/5/2016.
 */
public abstract class Building extends  implements LocatablePlanet
{
    private abstract double resistance;//resistance to damage
    private abstract double costToBuild;
    private abstract double costToMaintain;
    private int maximumOccupancy;
    public enum Type
    {
        
    }
    private CityBlock parentBlock;
    private Type type;
    private ArrayList<AbstractPerson> residents;
}
