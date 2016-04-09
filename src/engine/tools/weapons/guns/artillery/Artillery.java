package engine.tools.weapons.guns.artillery;

import engine.tools.weapons.guns.Gun;

/**
 * Created by bob on 4/3/2016.
 *
 */
public abstract class Artillery extends Gun {

	public Artillery(double accuracy, double damage, double range, double resistance, double startHealth) {
		super(accuracy, damage, range, resistance, startHealth);
	}
}
