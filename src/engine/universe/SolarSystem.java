package engine.universe;

import engine.planets.Planet;
import engine.planets.PlanetContainer;
import engine.planets.PlanetRandomConstructionContext;

import java.math.BigDecimal;
import java.util.ArrayList;


/**
 * Created by bob on 3/5/2016.
 *
 */
public class SolarSystem implements PlanetContainer
{
    BigDecimal x,y,z;
    private ArrayList<Planet> planets = new ArrayList<Planet>();
    private ArrayList<BigDecimal> radii = new ArrayList<>();
    public SolarSystem(BigDecimal x,BigDecimal y, BigDecimal z)
    {
        registerPlanetContainer();
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public SolarSystem(SolarSystemRandomConstructionContext s)
    {
	    registerPlanetContainer();
	    int numPlanets = utils.getRandomInt(s.numMinPlanets,s.numMaxPlanets);
	    for(int i = 0; i < numPlanets;i++)
	    {
			radii.add(i,utils.getRandomBigDecimal(s.minRadius,s.maxRadius));
		    PlanetRandomConstructionContext c = new PlanetRandomConstructionContext();
		    planets.add(new Planet(c));// TODO: 4/11/2016 planet construction cntext
	    }
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


    @Override
    public void remove(Planet planet) {
        planets.remove(planet);
    }
}
