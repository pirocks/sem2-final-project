package engine.universe;

//import java.math.BigDecimal;

/**
 * Created by bob on 4/10/2016.
 *
 */
public class UniverseConstructionContext
{
	public int numSolarSystems;
	public double universeRadius;
	public int numCountries;
	public int numMaxPlanets;
	public int numMinPlanets;
	public double solarSystemMinRadius; // TODO: 5/9/2016 include in startuup menus
	public double solarSystemMaxRadius;// TODO: 5/9/2016 include in startup menus
	public int numHazardsPerPlanet = 20;// TODO: 5/9/2016 include in startup menus
	public int minPlanetSize = 20;// TODO: 5/9/2016 include instartup menu
	public int maxPlanetSize = 1000;// TODO: 5/9/2016 include in startup menu
	public UniverseConstructionContext(int numSolarSystems,
	                                   double universeRadius,
	                                   int numCountries,
	                                   int numMinPlanets,
	                                   int numMaxPlanet
	)
	{
		this.numSolarSystems = numSolarSystems;
		this.universeRadius = universeRadius;
		this.numCountries = numCountries;
		this.numMaxPlanets = numMaxPlanets;
		this.numMinPlanets = numMinPlanets;
	}


}
