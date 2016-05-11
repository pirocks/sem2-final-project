package engine.cities;

import engine.planets.Grid;
import engine.planets.GridConstructionContext;
import engine.planets.LocationPlanet;
import engine.universe.Country;
import engine.universe.CountryConstructionContext;

import java.util.ArrayList;

/**
 * Created by bob on 4/10/2016.
 *
 */
public class CityConstructionContext {
	ArrayList<LocationPlanet> locationPlanet;//this is an arraylist which makes the entire city attackable and allows for the building sites to be pre-determined
	int population;
	//two basic types for now
	//industrial cities are porer than scientific and havve obvious differences in buildings
	static enum Type
	{
		Industrial,Scientific
	}
	Type type;
	ArrayList<CityConstructionContext> roadsTo;
	Country parentCountry;
	Grid parentGrid;
	public CityConstructionContext(CountryConstructionContext countryConstructionContext,
	                               GridConstructionContext gridConstructionContext)
	{

	}
}
