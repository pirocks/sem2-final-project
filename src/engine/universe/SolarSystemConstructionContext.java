package engine.universe;











import java.math.BigDecimal;
import java.util.ArrayList;
import engine.planets.*;
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
	public BigDecimal maxRadius;
	public BigDecimal minRadius;
	public PlanetConstructionContext context1;
	public PlanetConstructionContext context2;
    public PlanetConstructionContext context3;
  
	public SolarSystemConstructionContext(
			UnConstructedSolarSystem unConstructedSolarSystem,
			int numMaxPlanets, int numMinPlanets,
			ArrayList<Country> countries)
	{
		this.unConstructedSolarSystem = unConstructedSolarSystem;
		this.numMaxPlanets = numMaxPlanets;
		this.numMinPlanets = numMinPlanets;
		this.countries = countries;
	}
	public SolarSystemConstructionContext(UniverseConstructionContext u){
		numMaxPlanets = u.numMaxPlanets;
		numMinPlanets = u.numMinPlanets;
		maxRadius = new BigDecimal(u.);
		minRadius = new BigDecimal(u.);
	}
}
