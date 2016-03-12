package planets;

/**
 * Created by bob on 3/5/2016.
 */
 
 
 
import universe.UniqueId;
import planets.Grid;
import java.util.ArrayList;
import cities.AbstractPerson;
 
 
 
 
 
 
 
public class Country extends UniqueId
{
    public static String[] CountryNames = 
    {};
    public static int  countryNameCount;
    private ArrayList<Grid> grids;
    private String name;
    private ArrayList<Country> allies;
    private ArrayList<AbstractPerson> people;
    
    public Country()
    {
        
    }
}
