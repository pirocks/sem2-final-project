package engine.tools.weapons;


import engine.planets.LocationPlanet;

public abstract class Attackable_class
{
	private double startHealth;
	private double resistance;
	public LocationPlanet location;
	public Attackable_class(double startHealth,double resistance,LocationPlanet location) {
		this.startHealth = startHealth;
		this.resistance = resistance;
		this.location = location;
	}
	public boolean recieveDamage(double damage,Weapon attacker)
	{
//		assert(inRange(attacker.getRange(),attacker.getLocationPlanet()));// TODO: 5/5/2016 update this for arraylist locationd
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
	public abstract void die();
}