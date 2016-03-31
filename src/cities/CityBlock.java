

















package cities;

import planets.*;

public class CityBlock
{
    public int x,y;//between 0-100 inclusive??
    public LocationPlanet location;
    private Building building;
    private City parentCity;
    private Grid parentGrid;
    public CityBlock(Grid parentGrid,Building building,City parentCity,int x,int y)
    {
        this.parentGrid = parentGrid;
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
    public LocationPlanet getLocation()
    {
        return new LocationPlanet(this);
    }
    public Grid getGrid()
    {
        return parentGrid;
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