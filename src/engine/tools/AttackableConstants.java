package engine.tools;

import engine.planets.LocationPlanet;
import engine.tools.weapons.Attackable;
import engine.tools.weapons.Weapon;

/**
 * Created by bob on 4/9/2016.
 *
 */
public class AttackableConstants {
	public double health;
	public double resistance;
	public LocationPlanet locationPlanet;


	public AttackableConstants(double healthInitial, double resistanceInitial,LocationPlanet locationPlanet) {
		this.health= healthInitial;
		this.resistance = resistanceInitial;
		this.locationPlanet = locationPlanet;
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
