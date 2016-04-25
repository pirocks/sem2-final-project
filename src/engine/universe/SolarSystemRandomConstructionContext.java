package engine.universe;











import java.math.BigDecimal;
import java.util.ArrayList;
import engine.planets.*;
// import engine.universe.*;

/**
 * Created by bob on 4/10/2016.
 *
 */
public class SolarSystemRandomConstructionContext {
	public UnConstructedSolarSystem unConstructedSolarSystem;
	public ArrayList<Country> countries;
	public int numMinPlanets;
	public int numMaxPlanets;
	public BigDecimal maxRadius;
	public BigDecimal minRadius;
	public PlanetRandomConstructionContext context1;
	public PlanetRandomConstructionContext context2;
   public PlanetRandomConstructionContext context3;
  
	public SolarSystemRandomConstructionContext(
			UnConstructedSolarSystem unConstructedSolarSystem,
			int numMaxPlanets, int numMinPlanets,
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
