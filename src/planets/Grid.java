package planets;

import java.util.ArrayList;
import universe.UniqueId;
import planets.LocatablePlanet;
import universe.LocatableUniverse;
import cities.City;
import planets.NaturalResource;
/**
 * Created by bob on 3/5/2016.
 */

public class Grid extends UniqueId implements LocatablePlanet, LocatableUniverse
{
    private int x,y;
    private Planet parentPlanet;
    private Country parentCountry;
    private ArrayList<City> citys;
    private ArrayList<NaturalResource> naturalResources;
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
    public ArrayList<NaturalHazard> getHazards()
    {
        return hazards;
    }
    public ArrayList<NaturalResource> getNaturalResources()
    {
        return naturalResources;
    }
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public double getXInPlanet()
    {
        return (double)x;
    }
    public double getYInPlanet()
    {
        return (double)y;
    }
    public BigDecimal getZInUniverse()//top left corner of grid not actual center
    {
        BigDecimal planetZ = parentPlanet.getZInUniverse();
        
    }
    public BigDecimal getXInUniverse()
    {
        
    }
    public BigDecimal getYInUniverse()
    {
        
    }
}
