package engine.tools.weapons;


import engine.planets.LocationPlanet;
import engine.tools.AttackableConstants;

public abstract class Attackable
{
	private double startHealth;
	private double resistance;
	public LocationPlanet location;
	public Attackable(double startHealth,double resistance,LocationPlanet location)
	{
		this.startHealth = startHealth;
		this.resistance = resistance;
		this.location = location;
	}
	public Attackable(AttackableConstants a)
	{
		this.startHealth = a.health;
		this.resistance = a.resistance;
		this.location = a.locationPlanet;
	}
	public boolean receiveDamage(double damage, Weapon attacker)
	{
		assert(inRange(attacker.getRange(),attacker.getLocationPlanet()));
		startHealth -= damage/resistance;
		if(amIDead())
			return true;
		return false;
	}
	public boolean inRange(double range,LocationPlanet loc)
	{
		if(loc.distanceBetween(location) > range)
			return false;
		return true;
	}
	public boolean amIDead()
	{
		if(startHealth <= 0)
			return true;
		return false;
	}
	public boolean amIAlive()
	{
		if(startHealth > 0)
			return true;
		return false;
	}
	public LocationPlanet getLocationPlanet()
	{
		return location;
	}
	public LocationPlanet getLocation()
	{
		return location;
	}
	public abstract void die();
}