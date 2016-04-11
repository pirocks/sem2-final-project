package engine.universe;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by bob on 4/10/2016.
 *
 */
public class SolarSystemRandomConstructionContext {
	UnConstructedSolarSystem unConstructedSolarSystem;
	ArrayList<Country> countries;
	int numMinPlanets;
	int numMaxPlanets;
	BigDecimal maxRadius;
	BigDecimal minRadius;

	private SolarSystemRandomConstructionContext(
			UnConstructedSolarSystem unConstructedSolarSystem,
			int numMaxPlanets,int numMinPlanets,
			ArrayList<Country> countries)
	{
		this.unConstructedSolarSystem = unConstructedSolarSystem;
		this.numMaxPlanets = numMaxPlanets;
		this.numMinPlanets = numMinPlanets;
		this.countries = countries;
	}
	public SolarSystemRandomConstructionContext(UniverseRandomConstructionContext u){

	}
}
