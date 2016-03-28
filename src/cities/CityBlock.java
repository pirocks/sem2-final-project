

















package cities;

import planets.Grid;
import planets.LocatablePlanet;

public class CityBlock implements LocatablePlanet
{
    private Grid grid;
    private int x, y;//from 0 to 100. possibly use byte indidicate location within grid
    private Building building;
    private City parentCity;
    public CityBlock(Grid parentGrid,Building building,City parentCity,int x,int y)
    {
        this.building = building;
        this.parentCity = parentCity;
        if(parentGrid.cityBlockLocationExists(x,y))
            throw new IllegalArgumentException();
        this.x = x;
        this.y = y;
    }
    public City getParentCity()
    {
        return parentCity;
    }
    public Building getBuilding()
    {
        return building;
    }
    public double getXInPlanet()
    {
        double cityX = parentCity.getXInPlanet();
        return cityX + x/1000.0;//magic ixed. Will do with proper texeditor
    }
    public double getYInPlanet()
    {
        double cityY = parentCity.getXInPlanet();
        return cityY + y/1000.0;
    }
    public Grid getGrid()
    {
        return grid;
    }
    public int getXInGrid()
    {
        return x;
    }
    public int getYInGrid()
    {
        return y;
    }
}