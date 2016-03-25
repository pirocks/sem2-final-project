














package planets;

public interface LocatablePlanet
{
    public double getXInPlanet();//0,0 is top left of grid
    public double getYInPlanet();
    public Grid getGrid();
    public double getXInGrid();
    public double getYInGrid();
}