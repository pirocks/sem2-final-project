package engine.universe;

import java.math.BigDecimal;

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

	public UniverseConstructionContext(int numSolarSystems,
	                                   double universeRadius,
	                                   int numCountries,
	                                   int numMinPlanets,
	                                   int numMaxPlanets)
	{
		this.numSolarSystems = numSolarSystems;
		this.universeRadius = universeRadius;
		this.numCountries = numCountries;
		this.numMaxPlanets = numMaxPlanets;
		this.numMinPlanets = numMinPlanets;
	}


}
