package engine.universe;

//import java.math.BigDecimal;

import java.util.ArrayList;

/**
 * Created by bob on 4/10/2016.
 *
 */
public class UniverseConstructionContext
{
	public int numSolarSystems;
	public double universeRadius;
	public int numPlanets;
	public double solarSystemMinRadius; // TODO: 5/9/2016 include in startuup menus
	public double solarSystemMaxRadius;// TODO: 5/9/2016 include in startup menus
	public int numHazardsPerPlanet = 20;// TODO: 5/9/2016 include in startup menus
	public int minPlanetSize = 20;// TODO: 5/9/2016 include instartup menu
	public int maxPlanetSize = 25;// TODO: 5/9/2016 include in startup menu
	public ArrayList<Country> countries;
	public double industryProb;

	public UniverseConstructionContext(int numSolarSystems,
	                                   double universeRadius,
	                                   int numCountries,
	                                   int numPlanets,
	                                   int numHazardsPerPlanet,
	                                   double industryProb)
	{
		this.numSolarSystems = numSolarSystems;
		this.universeRadius = universeRadius;
		this.numPlanets = numPlanets;
		this.numHazardsPerPlanet = numHazardsPerPlanet;
		this.industryProb = industryProb;
		countries = new ArrayList<>();
		for(int i = 0; i < numCountries;i++)
			countries.add(new Country(this));
	}


}
