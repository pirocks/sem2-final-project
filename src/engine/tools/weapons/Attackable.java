package engine.tools.weapons;

import engine.planets.LocationPlanet;
import engine.tools.AttackableInitialConstants;

/**
 * Created by bob on 4/4/2016.
 * 
 */
public abstract class Attackable
{
	protected double health;
	protected double resistance;
	public Attackable(AttackableInitialConstants attackableInitialConstants)
	{
		this.health = attackableInitialConstants.healthInitial;
		this.resistance = attackableInitialConstants.resistanceInitial;
	}

	public abstract void receiveDamage(double damage, Weapon attacker);//posibly more types later
	public abstract void die();
	public abstract LocationPlanet getLocationPlanet();
}
