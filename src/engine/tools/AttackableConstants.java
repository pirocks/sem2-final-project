package engine.tools;

import engine.tools.weapons.Attackable;
import engine.tools.weapons.Weapon;

/**
 * Created by bob on 4/9/2016.
 *
 */
public class AttackableConstants {
	public double health;
	public double resistance;

	public AttackableConstants(double healthInitial, double resistanceInitial) {
		this.health= healthInitial;
		this.resistance = resistanceInitial;
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
