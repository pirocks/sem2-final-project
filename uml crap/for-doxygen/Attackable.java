package engine.tools.weapons;

import engine.planets.LocationPlanet;

/**
 * Created by bob on 4/4/2016.
 * 
 */
public interface Attackable
{
//	protected double health;
//	protected double resistance;
//	public Attackable(AttackableConstants attackableConstants)
//	{
//		this.health = attackableConstants.healthInitial;
//		this.resistance = attackableConstants.resistanceInitial;
//	}

	boolean receiveDamage(double damage);//posibly more types later
	void die();
	LocationPlanet getLocationPlanet();
}
