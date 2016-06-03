package engine.universe;

import engine.planets.PlanetConstructionContext;

import java.util.ArrayList;
// import engine.universe.*;

/**
 * Created by bob on 4/10/2016.
 *
 */
public class SolarSystemConstructionContext {
	//	public UnConstructedSolarSystem unConstructedSolarSystem;
	public ArrayList<Country> countries;
	public int numMinPlanets;
	public int numMaxPlanets;
	public double maxRadius;
	public double minRadius;
	public double x,y,z;//location
	public Star star;
	// : 5/9/2016 change this to an arraylist
	public PlanetConstructionContext context1;
	public PlanetConstructionContext context2;
    public PlanetConstructionContext context3;
  
	/*public SolarSystemConstructionContext(
			UnConstructedSolarSystem unConstructedSolarSystem,
			int numMaxPlanets, int numMinPlanets,
			ArrayList<Country> countries)
	{
//		this.unConstructedSolarSystem = unConstructedSolarSystem;
		this.numMaxPlanets = numMaxPlanets;
		this.numMinPlanets = numMinPlanets;
		this.countries = countries;
	}*/
	public SolarSystemConstructionContext(UniverseConstructionContext u){
		if(u.countries == null)
			throw new IllegalArgumentException();
		numMaxPlanets = u.numPlanets;
		numMinPlanets = 0;
		maxRadius = u.solarSystemMaxRadius;
		minRadius = u.solarSystemMinRadius;
		countries = u.countries;
		x = utils.getRandomDouble(0,u.universeRadius);
		y = utils.getRandomDouble(0,u.universeRadius);
		z = utils.getRandomDouble(0,u.universeRadius);
		context1 = generateRandomPlanetContext(u);
		context2 = generateRandomPlanetContext(u);
		context3 = generateRandomPlanetContext(u);
		if(countries == null)
			throw new IllegalArgumentException();
	}
	public PlanetConstructionContext generateRandomPlanetContext(UniverseConstructionContext u)
	{
		double radius = utils.getRandomDouble(u.solarSystemMinRadius,u.solarSystemMaxRadius);
		int gridNum = utils.getRandomInt(u.minPlanetSize,u.maxPlanetSize);
		double percentWater = utils.getRandomDouble(0.25,0.75);
		int numHazards = u.numHazardsPerPlanet;
		double IronAbundance = utils.getRandomDouble(0.25,0.75);
		double OilAbundance = utils.getRandomDouble(0.25,0.75);
		// : 5/9/2016 fix magic nums
		double WaterAbundance = utils.getRandomDouble(0.1,0.9);
		double FoodAbundance = utils.getRandomDouble(0.8,0.97);
		double HeliumAbundance = utils.getRandomDouble(0.01,0.2);
		double UraniumAbundance = utils.getRandomDouble(0.05,0.3);
		double citiesPerGrid = utils.getRandomDouble(0,0.05);// TODO: 5/11/2016 add in menu
		double industryProb = u.industryProb;// TODO: 5/11/2016 add this as an option in universe
		if(countries == null)
			throw new IllegalStateException();
		return new PlanetConstructionContext(
				radius,
				star,
				u.countries,
				gridNum,
				percentWater,
				numHazards,
				IronAbundance,
				OilAbundance,
				UraniumAbundance,
				HeliumAbundance,
				FoodAbundance,
				WaterAbundance,
				citiesPerGrid,
				industryProb);
	}
}
