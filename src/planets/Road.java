package planets;

import cities.City;
import cities.CityContainer;
import tools.weapons.Attackable;

import java.util.ArrayList;

public class Road implements Attackable, CityContainer
{
	public static double resistance;
	private double health = 1.0;
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

	@Override
	public void recieveDamage(double damage) {
		health = (health*resistance - damage)/resistance;
		if()
	}
}