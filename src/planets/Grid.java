package universe;

import java.util.ArrayList;

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
    public Grid(int x, int y,Country parentCountry,Planet parentPlanet)
    {
        this.x = x;
        this.y = y;
        this.parentCountry = parentCountry;
        this.parentPlanet = parentPlanet;
        Grid();//random generation
    }
    private Grid()
    {
        //random generation
    }
    public getParentCountry()
    {
        return parentCountry;
    }
    public registerHazard()
    {
        
    }
    
}
