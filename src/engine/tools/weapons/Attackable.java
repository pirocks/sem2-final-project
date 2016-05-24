package engine.tools.weapons;


import engine.planets.Grid;
import engine.planets.LocationPlanet;
import engine.tools.AttackableConstants;

import java.util.ArrayList;

public abstract class Attackable
{
	private double health;
	private double resistance;
	public ArrayList<LocationPlanet> location;

	public Attackable(double health, double resistance, ArrayList<LocationPlanet> location) {
		this.health = health;
		this.resistance = resistance;
		this.location = location;
	}
	public Attackable(AttackableConstants a) {
		if(a == null) {
			health = Integer.MAX_VALUE;
			resistance = Integer.MAX_VALUE;// TODO: 5/10/2016 better eway f habdling cityblock behavior?
		}
		else {
			this.health = a.health;
			this.resistance = a.resistance;
			this.location = a.locationPlanet;
		}
	}
	public boolean receiveDamage(double damage, Weapon attacker) {
		assert(inRange(attacker.getRange(),attacker.getLocationPlanet().get(0)));
		health -= damage/resistance;
		return amIDead();
	}
	public boolean inRange(double range,LocationPlanet loc) {
		for(LocationPlanet loc2:location)
			if(loc.distanceBetween(loc2) < range)
				return true;
		return false;
	}
	public boolean amIDead()
	{
		return health <= 0;
	}
	public boolean amIAlive()
	{
		return health > 0;
	}
	public double increaseHealth(double amount) {
		health += amount;
		return health;
	}
	public ArrayList<LocationPlanet> getLocationPlanet()
	{
		return location;
	}
	public ArrayList<LocationPlanet> getLocation() {
		assert (location.size() == 1);
		return location;
	}
	public double getHealth() {
		return health;
	}
	public abstract void die();

	public Grid getGrid() {
		return location.get(0).getGrid();
	}
}