


















package engine.tools.weapons;


public abstract class Attackable_class 
{
	private double startHealth;
	private double resistance;
	public LocationPlanet location;
	public Attackable_class(double startHealth,double resistance,LocationPlanet location)
	{
		this.startHealth = startHealth;
		this.resistance = resistance;
		this.location = location;
	}
	public recieveDamage(double damage,Weapon attacker)
	{
		assert(inRange(attacker.getLocationPlanet(),attacker.getRange());
		startHealth -= damage/resistance;
	}
	public boolean inRange(double range,LocationPlanet loc)
	{
		if(loc.distanceBetween(location) > range)
			return false;
		return true;
	}
	public LocationPlanet getLocationPlanet()
	{
		return location;
	}
	public abstract die();
}