package engine.planets;

import engine.cities.*;
import engine.planets.hazards.*;
import engine.tools.vehicles.Vehicle;
import engine.tools.weapons.Attackable;
import engine.universe.Country;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * Created by bob on 3/5/2016.
 * 
 * grids contain 100 cityblocks. Not in an array though
 */

public class Grid implements Serializable,Container
{
    private int x,y;
    private Planet parentPlanet;
    private Country parentCountry;

    private ArrayList<City> citys;
	private ArrayList<NaturalResource> naturalResources;
    private TerrainType terrainType;
    private ArrayList<NaturalHazard> hazards;
    private FarmLand farmLand;
	private ArrayList<Vehicle> vehicles;

	public Grid(GridConstructionContext gridConstructionContext,Planet parentPlanet){
	    this.parentPlanet = parentPlanet;
		registerContainer(parentPlanet);
	    x = gridConstructionContext.x;
	    y = gridConstructionContext.y;
	    naturalResources = gridConstructionContext.naturalResources;
	    terrainType = gridConstructionContext.getSuitableTerrainType();
	    hazards = new ArrayList<>();
	    double hazardProb = Math.random();
	    if(hazardProb < gridConstructionContext.hazardAbundance)
	    {
		    hazards.add(getRandomHazard());
		    hazardProb = Math.random();
		    if(hazardProb < gridConstructionContext.hazardAbundance)
		    {
			    hazards.add(getRandomHazard());
			    hazardProb = Math.random();
			    if(hazardProb < gridConstructionContext.hazardAbundance)
			    {
				    hazards.add(getRandomHazard());
			    }//up to three natural hazards
		    }
	    }
	    farmLand = new FarmLand(this);
	    //nowwe deal with  countries
	    parentCountry = gridConstructionContext.country;
	    //now we deal with the citys
	    if(gridConstructionContext.country == null)
	    {
		    //unclaimed land
		    citys = new ArrayList<>();
	    }
	    else {
		    gridConstructionContext.country.getGrids().add(this);
		    citys = new ArrayList<>();
		    double cityProb = gridConstructionContext.citiesPerGrid;
		    double rand = Math.random();
		    if(rand < cityProb)
		    {
			    try {
				    City city = new City(new CityConstructionContext(gridConstructionContext, terrainType, this));
				    citys.add(city);
				    registerContainer(city);
			    } catch (ToManyPeopleException e) {
				    e.printStackTrace();
			    }
		    }
	    }
		vehicles = new ArrayList<>();
		// TODO: 5/10/2016
    }
	private NaturalHazard getRandomHazard() {
		int type = (int) (Math.random()*5);
		switch (type)
		{
			case 0:
				return new Disease(this);
			case 1:
				return new Drought(this);
			case 2:
				return new Volcano(this);
			case 3:
				return new Weather(this);
			case 4:
				return new Earthquake(this);
			default:
				assert(false);
				throw new IllegalStateException();
		}
	}
	public Country getParentCountry()
    {
        return parentCountry;
    }
    public void registerHazard(NaturalHazard hazard){
        //TODO:figure this one out//natural hazards arwe scehdule  for deprecation
    }
    public ArrayList<NaturalHazard> getHazards()
    {
        return hazards;
    }
    public ArrayList<NaturalResource> getNaturalResources()
    {
        return naturalResources;
    }
    public boolean cityBlockLocationExists(int x, int y) {
        ArrayList<CityBlock> blocks = new ArrayList<>();
        for(City city:citys)
            blocks.addAll(city.getCityBlocks());
        for(CityBlock cityBlock:blocks)
            if(cityBlock.getXInGrid() == x && cityBlock.getYInGrid() == y)
                return true;
        return false;
    }
    //location stuff
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public double getXInPlanet()
    {
        return (double)x;
    }
    public double getYInPlanet()
    {
        return (double)y;
    }
    public Grid getGrid()
    {
        return this;
    }
    public double getXInGrid()
    {
        return 0;
    }
    public double getYInGrid()
    {
        return 0;//maybe I should return the center
    }
    public double getZInUniverse() {
	    //top left corner of grid not actual center
        double planetZ = parentPlanet.getZInUniverse();
        double planetHeight = parentPlanet.getplanetRadius();
        double startHeight = planetZ + planetHeight;
        double gridHeight = planetHeight*2/parentPlanet.getGridCountHeight();///should be built in as a constant and final. Planets should not be created that don't have the appropriate height
        return startHeight - y*gridHeight;
    }
    public double getXInUniverse() {
        double xAngle = ((double)x/(double)parentPlanet.getGridCountLength())*360.0;
        double planetX = parentPlanet.getXInUniverse();
        return planetX + (parentPlanet.getplanetRadius()*Math.cos(xAngle));
    }
    public double getYInUniverse() {
        double yAngle = ((double)y/(double)parentPlanet.getGridCountLength())*360.0;
        double planetY = parentPlanet.getYInUniverse();
        return planetY + (parentPlanet.getplanetRadius()*Math.sin(yAngle));
    }
    public Planet getParentPlanet()
    {
        return parentPlanet;
    }
	public void remove(City city) {
		if(citys.size() == 0)
			return;//performance optimization
		if(citys.remove(city))
			remove(city);
	}
	public void remove(Planet planet) {
		if(parentPlanet == planet)
		{
			parentPlanet = null;
			assert(false);
		}
	}
	@Override
	public String toString() {
		return "x:" + x + "y:" + y;// + "types:" + terrainType.toString();
	}
	public ArrayList<City> getCitys() {
        return citys;
    }
    public TerrainType getTerrainType() {
        return terrainType;
    }
    public FarmLand getFarmLand() {
        return farmLand;
    }
	public void vehicleArrives(Vehicle vehicle) {
		registerContainer(vehicle);
		vehicles.add(vehicle);
	}
	public void vehicleLeaves(Vehicle v){
		deregisterContainer(v);
		vehicles.remove(v);
	}
	public ArrayList<Vehicle> getVehicles() {
		return vehicles;
	}

	@Override
	public void remove(Attackable attackable) {
		if(attackable instanceof City)
			remove((City)attackable);
		else if(attackable instanceof Planet)
			remove((Planet) attackable);
		else
			throw new IllegalStateException();
	}
}
