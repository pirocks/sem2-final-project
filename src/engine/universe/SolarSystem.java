package engine.universe;

import engine.planets.Planet;
import engine.planets.PlanetConstructionContext;
import engine.planets.PlanetContainer;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * Created by bob on 3/5/2016.
 *
 */
public class SolarSystem implements PlanetContainer, Serializable
{
    double x,y,z;

	public Star getStar() {
		return star;
	}

	public void setStar(Star star) {//kind of awkward that this is necessary.
		this.star = star;
	}

	private Star star;
	public ArrayList<Planet> getPlanets() {
		return planets;
	}

	private ArrayList<Planet> planets = new ArrayList<Planet>();
    private ArrayList<Double> radii = new ArrayList<>();
    public String name;
	public static String[] solarSystemNames = {
		    "Kylar","Solar System 1","Solar System 2","Solar System 3"
    };
	public static int solarSystemNameCount = 0;
	@Deprecated public SolarSystem(double x, double y, double z, SolarSystem parentSolarSystem)
    {
        registerPlanetContainer();
        this.x = x;
        this.y = y;
        this.z = z;
	    star = new Star(x,y,z, parentSolarSystem);
	    setName();
    }
    public SolarSystem(SolarSystemConstructionContext s)
    {
	    registerPlanetContainer();
	    int numPlanets = utils.getRandomInt(s.numMinPlanets,s.numMaxPlanets);
	    for(int i = 0; i < numPlanets;i++)
	    {
			radii.add(i,utils.getRandomDouble(s.minRadius,s.maxRadius));
		    PlanetConstructionContext c = new PlanetConstructionContext(s);
		    planets.add(new Planet(c));// TODO: 4/11/2016 planet construction cntext
	    }
	    setName();
    }

	public void setName() {
		try {
			name = solarSystemNames[solarSystemNameCount];
		}
		catch (Exception e)
		{
			name = "Solar System" + solarSystemNameCount;
		}
		solarSystemNameCount++;
	}

	public double getXInUniverse()
    {
        return x;
    }
    public double getYInUniverse()
    {
        return y;
    }
    public double getZInUniverse()
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
