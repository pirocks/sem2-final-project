

















package cities;

import planets.Grid;
import planets.LocatablePlanet;

public class CityBlock
{
    public LocationPlanet location;
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
}