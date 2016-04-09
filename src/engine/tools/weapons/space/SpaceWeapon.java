package engine.tools.weapons.space;

import engine.tools.weapons.Weapon;

import java.math.BigDecimal;

/**
 * Created by bob on 4/4/2016.
 *
 */
public abstract class SpaceWeapon extends Weapon {
	public BigDecimal range;
	public SpaceWeapon(double damage,BigDecimal range, double resistance, double startHealth) {
		super(damage, resistance, startHealth);
		this.range = range;
	}
}
