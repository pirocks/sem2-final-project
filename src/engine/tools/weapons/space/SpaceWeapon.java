package engine.tools.weapons.space;

import engine.tools.AttackableConstants;
import engine.tools.weapons.Weapon;

import java.math.BigDecimal;

/**
 * Created by bob on 4/4/2016.
 *
 */
public abstract class SpaceWeapon extends Weapon {
	public double range;
	public SpaceWeapon(AttackableConstants attackableConstants, double damage, double range) {
		super(attackableConstants,damage, range);
		this.range = range;
	}
}
