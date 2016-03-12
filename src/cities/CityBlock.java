package cities;

import universe.UniqueId;
import planets.LocatablePlanet;

public class CityBlock extends UniqueId implements LocatablePlanet
{
    private Building building;
    private City parentCity;
    private double x, y;
    public CityBlock(Building building,City parentCity,double x,double y)
    {
        this.building = building;
        this.parentCity = parentCity;
        this.x = x;
        this.y = y;
    }
}