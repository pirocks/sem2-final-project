package engine.planets;

import engine.cities.City;
import engine.cities.CityContainer;
import engine.tools.vehicles.Vehicle;
import engine.tools.vehicles.VehicleContainer;
import engine.tools.weapons.Attackable;

import java.io.Serializable;
import java.util.ArrayList;

public class Road extends Attackable implements Serializable ,CityContainer, VehicleContainer {
	public static double resistanceInitial;
	public static double healthInitial;
	//	private AttackableConstants attackableConstants;
	private ArrayList<City> cities;//citie that road passes through, not to be used for rendering or distance calculation
	//vehicles that are on the road cannot be attacked, however the road can be
	//if the road is destroyed completely then vehicles that sare onthe road are also destroyed
	private ArrayList<Vehicle> vehiclesOnRoad;
	private ArrayList<LocationPlanet> locations;

	public Road(ArrayList<City> cities) {
		super(healthInitial, resistanceInitial, null);
//		attackableConstants = new AttackableConstants(healthInitial,resistanceInitial);
		registerCityContainer();
		registerVehicleContainer();
		if (cities.size() < 2)
			throw new IllegalArgumentException();
		this.cities = new ArrayList<>(cities);
		ArrayList<LocationPlanet> initialLocations = new ArrayList<>();
		for (City city : cities)
			initialLocations.addAll(city.getLocationPlanet());
		ArrayList<LocationPlanet> finalout = new ArrayList<>(initialLocations.size() * 4);//// TODO: 4/9/2016 figure out if this is the correct initial size
		for (int i = 0; i < initialLocations.size() - 1; i++) {
			LocationPlanet a = initialLocations.get(i);
			LocationPlanet b = initialLocations.get(i + 1);
			LocationPlanet mid = LocationPlanet.mediumLocation(a, b);
			LocationPlanet lowerMid = LocationPlanet.mediumLocation(a, mid);
			LocationPlanet upperMid = LocationPlanet.mediumLocation(mid, b);
			finalout.add(a);
			finalout.add(lowerMid);
			finalout.add(mid);
			finalout.add(upperMid);
			finalout.add(b);
		}
		locations = finalout;
	}

	public boolean passesThrough(City a) {
		for (City c : cities) {
			if (c == a)
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
	public void die() {
		RoadContainer.killRoad(this);
	}
}