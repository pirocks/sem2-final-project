package engine.planets;

import engine.cities.City;
import engine.cities.CityContainer;
import engine.tools.AttackableConstants;
import engine.tools.vehicles.Vehicle;
import engine.tools.vehicles.VehicleContainer;
import engine.tools.weapons.Attackable;
import engine.tools.weapons.Weapon;

import java.io.Serializable;
import java.util.ArrayList;

public class Road implements Serializable,Attackable ,CityContainer, VehicleContainer
{
	public static double resistanceInitial;
	public static double healthInitial;
	private AttackableConstants attackableConstants;
	private ArrayList<City> cities;//citie that road passes through, not to be used for rendering or distance calculation
	//vehicles that are on the road cannot be attacked, however the road can be
	//if the road is destroyed completely then vehicles that sare onthe road are also destroyed
	private ArrayList<Vehicle> vehiclesOnRoad;
	private ArrayList<LocationPlanet> locations;
	public Road(ArrayList<City> cities) {
		attackableConstants = new AttackableConstants(healthInitial,resistanceInitial);
		registerCityContainer();
		registerVehicleContainer();
		if(cities.size() < 2)
			throw new IllegalArgumentException();
		this.cities = new ArrayList<>(cities);
		ArrayList<LocationPlanet> initialLocations = new ArrayList<>();
		for(City city:cities)
			initialLocations.add(city.getLocationPlanet());
		ArrayList<LocationPlanet> finalout = new ArrayList<>(initialLocations.size()*4);//// TODO: 4/9/2016 figure out if this is the correct initial size
		for(int i = 0; i < initialLocations.size()- 1;i++)
		{
			LocationPlanet a = initialLocations.get(i);
			LocationPlanet b = initialLocations.get(i + 1);
			LocationPlanet mid = LocationPlanet.mediumLocation(a,b);
			LocationPlanet lowermid = LocationPlanet.mediumLocation(a,mid);
			LocationPlanet uppermid = LocationPlanet.mediumLocation(mid,b);
			finalout.add(a);
			finalout.add(lowermid);
			finalout.add(mid);
			finalout.add(uppermid);
			finalout.add(b);
		}
		locations = finalout;
	}
	public boolean passesThrough(City a) {
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
	//TODO:implement this//also make sure that death is handled correctly and that the weapon is notified of successful attack
	public boolean receiveDamage(double damage) {
		return attackableConstants.receiveDamage(damage,this);
	}
	@Override
	public void die() {
		// TODO: 4/9/2016
	}
	@Override
	public LocationPlanet getLocationPlanet() {
		return null;// TODO: 4/9/2016
	}
}