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
}