package engine.tools.weapons.guns;

import engine.tools.ToolInitialConstants;

/**
 * Created by bob on 4/9/2016.
 *
 */
public class GunInitialConstants {
	public ToolInitialConstants toolInitialConstants;
	public double accuracy;
	public double range;
	public double damage;
	public GunInitialConstants(ToolInitialConstants toolInitialConstants,double accuracy,double range,double damage){
		toolInitialConstants = toolInitialConstants;
		this.accuracy = accuracy;
		this.range = range;
		this.damage = damage;
	}
	public GunInitialConstants(double healthInitial,
	                           double resitanceIntial,
	                           double accuracy,
	                           double range,
	                           double damage) {
		this(new ToolInitialConstants(healthInitial,resitanceIntial),accuracy,range,damage);
	}
}
