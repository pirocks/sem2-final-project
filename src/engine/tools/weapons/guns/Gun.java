package engine.tools.weapons.guns;

import engine.tools.weapons.Weapon;

/**
 * Created by bob on 4/4/2016.
 *
 */
public abstract class Gun extends Weapon
{
	protected double accuracy;//double from 0 to 1 indicating percent chance of hitting
	protected double range;
	public Gun(GunInitialConstants gunInitialConstants) {
		super(gunInitialConstants.attackableConstants,gunInitialConstants.damage, gunInitialConstants.range, numToolsConstructor);
		accuracy = gunInitialConstants.accuracy;
		range = gunInitialConstants.range;
	}
}
