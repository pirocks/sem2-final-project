package planets;

import java.util.ArrayList;
import universe.UniqueId;
import planets.LocatablePlanet;
import universe.LocatableUniverse;
import cities.City;
/**
 * Created by bob on 3/5/2016.
 */

public class Grid extends UniqueId implements LocatablePlanet, LocatableUniverse
{
    private int x,y;
    private Planet parentPlanet;
    private Country parentCountry;
    private ArrayList<City> citys;
    private ArrayList<NaturalResource> resources;
    private TerrainType terrainType;
    private ArrayList<NaturalHazard> hazards;
    private Grid()
    {
        //random generation
    }
    public Grid(int x, int y,Country parentCountry,Planet parentPlanet)
    {
        this();//random generation
        this.x = x;
        this.y = y;
        this.parentCountry = parentCountry;
        this.parentPlanet = parentPlanet;
    }
    public Country getParentCountry()
    {
        return parentCountry;
    }
    public void registerHazard(NaturalHazard hazrad)//natural hzard v regular hazzrad
    {
        
    }
    
}
