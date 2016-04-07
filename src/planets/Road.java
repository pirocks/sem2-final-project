package planets;

import cities.City;
import cities.CityContainer;
import tools.vehicles.Vehicle;
import tools.vehicles.VehicleContainer;
import tools.weapons.Attackable;
import tools.weapons.Weapon;

import java.util.ArrayList;

public class Road implements Attackable, CityContainer, VehicleContainer
{
	public static double resistance;
	private double health = 1.0;
	private ArrayList<City> cities;//citie that road passes through, not to be used for rendering or distance calculation
	//vehicles that are on the road cannot be attacked, however the road can be
	//if the road is destroyed completely then vehicles that sare onthe road are also destroyed
	private ArrayList<Vehicle> vehiclesOnRoad;
	private ArrayList<LocationPlanet> locations;
	//TODO make a constructor  and make sure it registers containers
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
	public void remove(City city) {
		cities.remove(city);
	}

	@Override
	public void remove(Vehicle vehicle) {
		vehiclesOnRoad.remove(vehicle);
	}

	@Override
	//TODO:implement this//also make sure that death is handled correctly and thatthe wapon is notified of succsessful attac
	public void receiveDamage(double damage, Weapon attacker) {
		health = (health*resistance - damage)/resistance;
		if(health < 0)
		{

		}
	}
}