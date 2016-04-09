package engine.tools.weapons;

import engine.planets.LocationPlanet;

/**
 * Created by bob on 4/4/2016.
 * 
 */
public interface Attackable
{
	public void receiveDamage(double damage, Weapon attacker);//posibly more types later
	public void die();
	public LocationPlanet getLocationPlanet();
}
