package engine.tools.weapons.guns;

import engine.tools.AttackableInitialConstants;

/**
 * Created by bob on 4/9/2016.
 *
 */
public class GunInitialConstants {
	public AttackableInitialConstants attackableInitialConstants;
	public double accuracy;
	public double range;
	public double damage;
	public GunInitialConstants(AttackableInitialConstants attackableInitialConstants, double accuracy, double range, double damage){
		attackableInitialConstants = attackableInitialConstants;
		this.accuracy = accuracy;
		this.range = range;
		this.damage = damage;
	}
	public GunInitialConstants(double healthInitial,
	                           double resitanceIntial,
	                           double accuracy,
	                           double range,
	                           double damage) {
		this(new AttackableInitialConstants(healthInitial,resitanceIntial),accuracy,range,damage);
	}
}
