package planets;

/**
 * Created by bob on 3/5/2016.
 */
 
import universe.UniqueId;
import java.util.ArrayList;
public class InhabitedPlanet extends Planet
{
    private ArrayList<Country> countrys;
    private ArrayList<Continent> continents;
    public InhabitedPlanet(ArrayList<Country> countries, ArrayList<Continent> continents,int size)
    {
        super(size);
        this.continents = continents;
        this.countrys = countrys;
    }
    
}
