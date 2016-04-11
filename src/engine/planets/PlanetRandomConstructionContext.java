package engine.planets;

import engine.universe.Country;
import engine.universe.SolarSystemRandomConstructionContext;
import engine.universe.Star;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by bob on 4/10/2016.
 *
 */
public class PlanetRandomConstructionContext
{
	BigDecimal radius;
	Star star;
	ArrayList<Country> countries;
	int gridNum;
	double percentWater;
	int numHazards;
//	public static enum ResourceAbundance
//	{
//		veryLow,low, mediumLow,medium, mediumHigh,high, veryHigh
//	}
	double IronAbundance;//0 is none while 1 is all grids have it
	double OilAbundance;
	double UraniumAbundance;
	double HeliumAbundance;
	double FoodAbundance;
	double WaterAbundance;
	public PlanetRandomConstructionContext(SolarSystemRandomConstructionContext s) {

	}

}
