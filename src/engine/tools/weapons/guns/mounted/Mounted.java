package engine.tools.weapons.guns.mounted;

import engine.tools.weapons.guns.Gun;

/**
 * Created by bob on 4/4/2016.
 *
 */
public abstract class Mounted extends Gun {


	public Mounted(double accuracy, double damage, double range, double resistance, double startHealth) {
		super(accuracy, damage, range, resistance, startHealth);
	}
}
