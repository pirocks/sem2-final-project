package engine.tools.weapons.guns;

import engine.tools.AttackableConstants;

/**
 * Created by bob on 4/9/2016.
 *
 */
public class GunInitialConstants {
	public AttackableConstants attackableConstants;
	public double accuracy;
	public double range;
	public double damage;
	public GunInitialConstants(AttackableConstants attackableConstants, double accuracy, double range, double damage){
		attackableConstants = attackableConstants;
		this.accuracy = accuracy;
		this.range = range;
		this.damage = damage;
	}
	public GunInitialConstants(double healthInitial,
	                           double resitanceIntial,
	                           double accuracy,
	                           double range,
	                           double damage) {
		this(new AttackableConstants(null,healthInitial,resitanceIntial),accuracy,range,damage);
	}
}
