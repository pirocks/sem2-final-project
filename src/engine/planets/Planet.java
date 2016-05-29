package engine.planets;
/**
 * Created by bob on 3/5/2016.
 *
 */

import engine.cities.City;
import engine.cities.Container;
import engine.tools.vehicles.Vehicle;
import engine.tools.weapons.Attackable;
import engine.universe.Country;
import engine.universe.SolarSystem;

import java.io.Serializable;
import java.util.ArrayList;
/*planet contains the following:
    grid array that serves as building block of planet
    resources on each grid array
    possible hazards volcano,temperature changes,weather. hazards are local to grid array*/
public class Planet extends Attackable implements Serializable
{
	public static double resitanceInitial;
	public static double startHeathInitial;
	//TODO make a better constructor
    private ArrayList<Country> countries = new ArrayList<>();
    private ArrayList<Continent> continents = new ArrayList<>();
    boolean inhabitedq = false;
    private SolarSystem parentSolarSystem;
    private double solarSystemRadius;//distance in engine.universe units from center of solar sstem
    private double planetRadius;//radiusFromSolarSystem of spher planet
    @Deprecated private double orientationAtCurrentTime;//0 to 360 degrees//need something to be done every second
    private Grid[][] grids;//make sure that # of grids is based on size of planet, to maintain coherent sizing of everything
    public static String[] names = {"Earth","Mars","Venus","Mercury","Jupiter","Pluto","Saturn","Neptune","Uranus"};
	private static int nameCount = 0;
	public String name;
	private Vehicle[] allVehicles;

	private void setName() {
		try {
			name = names[nameCount];
		} catch (Exception e) {
			name = "Planet#" + nameCount;
		}
		nameCount++;
	}
    public Planet(int size) {
	    super(resitanceInitial,startHeathInitial,new ArrayList<LocationPlanet>(){{add(new LocationPlanet(null,0,0,0,0));}});
	    for (LocationPlanet locationPlanet : super.location) {
		    locationPlanet.setPlanet(this);
	    }
        grids = new Grid[size][size * 2];
	    setName();
    }
    public Planet(PlanetConstructionContext c, SolarSystem solarSystem) {
	    super(resitanceInitial,startHeathInitial,new ArrayList<LocationPlanet>(){{add(new LocationPlanet(null,0,0,0,0));}});
	    for (LocationPlanet locationPlanet : super.location) {
		    locationPlanet.setPlanet(this);
	    }
	    parentSolarSystem = solarSystem;
	    GridConstructionContext[][] futureGrids = new GridConstructionContext[c.gridNum][c.gridNum];
	    grids = new Grid[c.gridNum][c.gridNum];
	    int numCounties = c.countries.size();
	    int planetSize = futureGrids.length*futureGrids[0].length;
	    int expectedCountrySize = planetSize/numCounties;
	    //so now lets cut up the world into countries
	    Country[][] countries = new Country[c.gridNum][c.gridNum];
	    // TODO: 5/11/2016 improve this,  paint fil recursive style method?
	    int countryGridCount = 0;
	    int countryIndex = 0;
	    for(int y = 0; y < futureGrids.length;y++)
	        for(int x = 0; x < futureGrids[y].length;x++)
	        {
		        try {
			        countries[y][x] = c.countries.get(countryIndex);
		        } catch (IndexOutOfBoundsException e) {
			        break;//assume that all countries have been done already and that exception is caused by rounding error
		        }
		        countryGridCount++;
		        if(countryGridCount >= expectedCountrySize)
		        {
			        countryGridCount = 0;
			        countryIndex++;
		        }
	        }

	    for(int y = 0; y < futureGrids.length;y++)
		    for(int x = 0;x < futureGrids[y].length;x++)
		    {
			    futureGrids[y][x] = new GridConstructionContext(c,grids,y,x,c.cityDensity,countries[y][x], c.industryProb);
			    grids[y][x] = new Grid(futureGrids[y][x],this);
		    }

		//misc cleanup stuff
	    setName();
	    double surfaceArea = (double)(grids.length*grids[0].length);//todo multiply by conversion factor
//	    A = 4 pi r^2
	    planetRadius = Math.sqrt(surfaceArea/4/Math.PI);
//	    parentSolarSystem = c.star.getParentSolarSystem();
	    solarSystemRadius = c.radiusFromSolarSystem;
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
    //planets always orbit solar system along x y plane.
    public double getZInUniverse()
    {
        return parentSolarSystem.getZInUniverse();
    }
    public double getXInUniverse() {
        double parentX = parentSolarSystem.getXInUniverse();
        return parentX + planetRadius*Math.cos(orientationAtCurrentTime);
    }
    public double getYInUniverse() {
        double parentY = parentSolarSystem.getYInUniverse();
        return parentY + planetRadius*Math.sin(orientationAtCurrentTime);
    }
	public  ArrayList<City> getAllCities() {
		ArrayList<City> out = new ArrayList<>();
		for(Grid[] grids1 :grids)
			for(Grid grid: grids1)
				out.addAll(grid.getCitys());
		return out;
	}
	//probs won't use this
	public ArrayList<City> getCountriesCities(Country country) {
		ArrayList<City> out = new ArrayList<>();
		ArrayList<City> cities = getAllCities();
		for(City city: cities)
			if(city.getParentCountry() == country)//maybe use a .equals later
				out.add(city);

		return out;
	}
	@Override
	public String toString() {
		String out = "Planet:" + name + "\n";
		out += "Occupying Countries:" + countries;
		return out;
	}
	public Grid[][] getGrids() {
		return grids;
	}
	public double getSolarSystemRadius() {
		return solarSystemRadius;
	}
	public SolarSystem getParentSolarSystem() {
		return parentSolarSystem;
	}
	@Override
	public void die() {
		Container.kill(this);
	}

	public ArrayList<Vehicle> getAllVehicles() {
		ArrayList<Vehicle> out = new ArrayList<>();
		for(Grid[] row: grids)
			for(Grid grid: row)
			{
				out.addAll(grid.getVehicles());
			}
		return out;
	}
}
