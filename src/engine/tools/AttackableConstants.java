package engine.tools;

import engine.planets.LocationPlanet;
import engine.tools.weapons.Attackable;

import java.util.ArrayList;

/**
 * Created by bob on 4/9/2016.
 *
 */
public class AttackableConstants {
	public double health;
	public double resistance;
	public ArrayList<LocationPlanet> locationPlanet;


	public AttackableConstants(double healthInitial, double resistanceInitial, LocationPlanet locationPlanet) {
		this.health= healthInitial;
		this.resistance = resistanceInitial;
		this.locationPlanet = new ArrayList<>(1);
		this.locationPlanet.add(locationPlanet);
	}

	public AttackableConstants(double healthInitial, double resistanceInitial, ArrayList<LocationPlanet> location) {
		this.health= healthInitial;
		this.resistance = resistanceInitial;
		this.locationPlanet = location;
	}

	public AttackableConstants(ArrayList<LocationPlanet> location, double healthInitial, double resistanceInitial) {
		this(healthInitial,resistanceInitial,location);
	}

	public boolean receiveDamage(double damage, Attackable attacked)
	{
		health -= damage/resistance;
		if(health <= 0) {
			attacked.die();
			return true;
		}
		return false;
	}
}
