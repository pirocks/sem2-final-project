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
    public static int countryNameCount;
    private ArrayList<Grid> grids;
    private String name;
    private ArrayList<Country> allies;
    private ArrayList<Country> atWarWith;
    private ArrayList<AbstractPerson> people;
    private City capitalCity;
    private //capital city whitehhouse
    public static enum GovernmentType
    {
        Democracy,Communist,Fascist,Totalitarian
    }
    private GovernmentType governmentType;
    public Country()
    {
        
    }
    public ArrayList<NaturalHazard> getNaturalHazards()
    {
        ArrayList<NaturalHazard> out = new ArrayList<NaturalHazard>();
        for(Grid grid:grids)
        {
            ArrayList<NaturalHazard> hazards = grid.getHazards();
            for(NaturalHazard hazard:hazards)
                out.add(hazard);
        }
    }
    public ArrayList<NaturalResources> getNaturalResourcess()
    {
        ArrayList<NaturalResources> out = new ArrayList<NaturalResources>();
        for(Grid grid:grids)
        {
            ArrayList<NaturalResources> naturalResources = grid.getNaturalResources();
            for(NaturalResources hazard:hazards)
                out.add(hazard);
        }
    }
    public getGovermentType()
    {
        return governmentType;
    }
    public getCapitalCity()
    {
        return capitalCity;
    }
}
