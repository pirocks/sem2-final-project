package universe;

import java.util.ArrayList;
import planets.Planet;
import planets.InhabitedPlanet;
import universe.UniqueId;

/**
 * Created by bob on 3/5/2016.
 */
public class SolarSystem extends UniqueId
{
    BigDecimal x,y,z;
    private ArrayList<Planet> planets = new ArrayList<Planet>();
    private ArrayList<double> radii = new ArrayList<>();
    private ArrayList<InhabitedPlanet> inhabitedPlanets = new ArrayList<InhabitedPlanet>();//also contained in planets array
    public SolarSystem(BigDecimal x,BigDecimal y, BigDecimal z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }



}
