package planets;

import java.util.ArrayList;
import universe.UniqueId;
import planets.LocatablePlanet;
import universe.LocatableUniverse;
import cities.City;
import planets.NaturalResource;
import java.math.BigDecimal;
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
        double planetHeight = parentPlanet.getplanetRadius();
        BigDecimal startHeight = planetZ.add(new BigDecimal(planetHeight));
        BigDecimal gridHeight = new BigDecimal(planetHeight*2/parentPlanet.getGridCountHeight());///should be built in as a constant and final. Planets should not be created that don't have the appropriate height
        return startHeight.subtract((new BigDecimal(y)).multiply(gridHeight));
    }
    public BigDecimal getXInUniverse()
    {
        double xAngle = ((double)x/(double)parentPlanet.getGridCountLength())*360.0;
        BigDecimal planetX = parentPlanet.getXInUniverse();
        return planetX.add(new BigDecimal(parentPlanet.getplanetRadius()*Math.cos(xAngle)));
    }
    public BigDecimal getYInUniverse()
    {
        double yAngle = ((double)y/(double)parentPlanet.getGridCountLength())*360.0;
        BigDecimal planetY = parentPlanet.getYInUniverse();
        return planetY.add(new BigDecimal(parentPlanet.getplanetRadius()*Math.sin(yAngle)));
    }
}
