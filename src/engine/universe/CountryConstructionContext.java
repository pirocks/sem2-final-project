package engine.universe;

import engine.cities.City;
import engine.people.AbstractPerson;
import engine.planets.Grid;
import engine.planets.Planet;

import java.util.ArrayList;

/**
 * Created by bob on 5/7/2016.
 *
 */
public class CountryConstructionContext
{
	public Planet planet;
	public ArrayList<Grid> grids;
	public ArrayList<AbstractPerson> person;
	public CountryConstructionContext(Planet planet,
	                                  ArrayList<Grid> grids,
	                                  ArrayList<AbstractPerson> people)
	{

	}
}
