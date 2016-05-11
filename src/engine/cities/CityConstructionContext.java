package engine.cities;

import engine.planets.LocationPlanet;
import engine.universe.Country;
import engine.universe.CountryConstructionContext;

import java.util.ArrayList;

/**
 * Created by bob on 4/10/2016.
 *
 */
public class CityConstructionContext {
	LocationPlanet locationPlanet;
	int population;
	//two basic types for now
	//industrial cities are porer than scientific and havve obvious differences in buildings
	static enum Type
	{
		Industrial,Scientific
	}
	ArrayList<CityConstructionContext> roadsTo;
	Country parentCountry;
	public CityConstructionContext(CountryConstructionContext countryConstructionContext,)
	{

	}
}
