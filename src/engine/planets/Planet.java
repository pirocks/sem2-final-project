package engine.planets;
/**
 * Created by bob on 3/5/2016.
 *
 */

import engine.universe.Country;
import engine.universe.CountryContainer;
import engine.universe.SolarSystem;

import java.io.Serializable;
import java.util.ArrayList;
/*planet contains the following:
    grid array that serves as building block of planet
    resources on each grid array
    possible hazards volcano,temperature changes,weather. hazards are local to grid array*/
public class Planet implements Serializable,CountryContainer
{
	//TODO make a better constructor
    private ArrayList<Country> countries = new ArrayList<>();
    private ArrayList<Continent> continents = new ArrayList<>();
    boolean inhabitedq = false;
    private SolarSystem parentSolarSystem;
    private double radius;//distance in engine.universe units from cemter of solar sstem
    private double planetRadius;//radius of spher planet
    private double orientationAtCurrentTime;//0 to 360 degrees//need something to be done every second
    private Grid[][] grids;//make sure that # of grids is based on size of plannet, to maintain coherent sizing of everything
    public static String[] names = {"Earth","Mars","Venus","Mercury","Jupiter","Pluto","Saturn","Neptune","Uranus"};
	public static int nameCount = 0;
	public String name;

	public void setName()
	{
		try {
			name = names[nameCount];
		} catch (Exception e) {
			name = "Planet#" + nameCount;
		}
		nameCount++;
	}

    public Planet(int size)
    {
        registerCountryContainer();
        grids = new Grid[size][size * 2];
	    setName();
    }

    public Planet(PlanetConstructionContext c) {
		setName();
    }

    public double getplanetRadius()
    {
        return planetRadius;
    }
    public int getGridCountHeight()
    {
        return grids.length;
    }
    public int getGridCountLength()
    {
        return grids[0].length;
    }
    //plaanets always orbit solar system along x y plane.
    public double getZInUniverse()
    {
        return parentSolarSystem.getZInUniverse();
    }
    public double getXInUniverse() {
        double parentX = parentSolarSystem.getXInUniverse();
        return parentX + radius*Math.cos(orientationAtCurrentTime);
    }
    public double getYInUniverse() {
        double parentY = parentSolarSystem.getYInUniverse();
        return parentY + radius*Math.sin(orientationAtCurrentTime);
    }
    @Override
    public void remove(Country country,Country conqueror) {
        countries.remove(country);
        if(!countries.contains(conqueror))
	        countries.add(conqueror);
    }
}
