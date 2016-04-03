package planets;

import cities.City;

import java.util.ArrayList;

public class Road
{
	private ArrayList<City> cities;
	private ArrayList<LocationPlanet> locations;
	public boolean passesThrough(City a)
	{
		for(City c:cities)
		{
			if(c == a)
				return true;
		}
		return false;
	}
}