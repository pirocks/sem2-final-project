package engine.tools.weapons.space;

import engine.tools.weapons.Weapon;

/**
 * Created by bob on 4/4/2016.
 *
 */
public abstract class SpaceWeapon extends Weapon {
	public SpaceWeapon(double damage, double resistance, double startHealth) {
		super(damage, resistance, startHealth);
	}
}
