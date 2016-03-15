package universe;

import java.util.ArrayList;
import java.math.BigDecimal;
import planets.Planet;
import planets.InhabitedPlanet;
import universe.UniqueId;
import universe.LocatableUniverse;
/**
 * Created by bob on 3/5/2016.
 */
public class SolarSystem extends UniqueId implements LocatableUniverse
{
    BigDecimal x,y,z;
    private ArrayList<Planet> planets = new ArrayList<Planet>();
    private ArrayList<Double> radii = new ArrayList<>();
    private ArrayList<InhabitedPlanet> inhabitedPlanets = new ArrayList<InhabitedPlanet>();//also contained in planets array
    public SolarSystem(BigDecimal x,BigDecimal y, BigDecimal z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public BigDecimal getXInUniverse()
    {
        return x;
    }
    public BigDecimal getYInUniverse()
    {
        return y;
    }
    public BigDecimal getZInUniverse()
    {
        return z;
    }


}
