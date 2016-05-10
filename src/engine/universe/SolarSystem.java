package engine.universe;

import engine.planets.Planet;
import engine.planets.PlanetConstructionContext;
import engine.planets.PlanetContainer;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;


/**
 * Created by bob on 3/5/2016.
 *
 */
public class SolarSystem implements PlanetContainer, Serializable
{
    BigDecimal x,y,z;

	public ArrayList<Planet> getPlanets() {
		return planets;
	}

	private ArrayList<Planet> planets = new ArrayList<Planet>();
    private ArrayList<BigDecimal> radii = new ArrayList<>();
    public String name;
	public static String[] solarSystemNames = {
		    "Kylar","Solar System 1","Solar System 2","Solar System 3"
    };
	public static int solarSystemNameCount = 0;
	@Deprecated public SolarSystem(BigDecimal x,BigDecimal y, BigDecimal z)
    {
        registerPlanetContainer();
        this.x = x;
        this.y = y;
        this.z = z;
	    setName();
	    solarSystemNameCount++;
    }
    public SolarSystem(SolarSystemConstructionContext s)
    {
	    registerPlanetContainer();
	    int numPlanets = utils.getRandomInt(s.numMinPlanets,s.numMaxPlanets);
	    for(int i = 0; i < numPlanets;i++)
	    {
			radii.add(i,utils.getRandomBigDecimal(s.minRadius,s.maxRadius));
		    PlanetConstructionContext c = new PlanetConstructionContext(s);
		    planets.add(new Planet(c));// TODO: 4/11/2016 planet construction cntext
	    }
	    setName();
	    solarSystemNameCount++;
    }

	public void setName() {
		try {
			name = solarSystemNames[solarSystemNameCount];
		}
		catch (Exception e)
		{
			name = "Solar System" + solarSystemNameCount;
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

	@Override
	public String toString() {
		String out = "";
		out += "Name:" + name;
		out += "\nPlanets" + planets.toString();
		return out;
	}
}
