package engine.tools.weapons.guns.carried;

import engine.tools.weapons.guns.Gun;
import engine.tools.weapons.guns.GunInitialConstants;

/**
 * Created by bob on 4/4/2016.
 *
 */
public abstract class Carried extends Gun {

	public Carried(GunInitialConstants gunInitialConstants, int numToolsConstructor) {
		super(gunInitialConstants, numToolsConstructor);
	}
}
