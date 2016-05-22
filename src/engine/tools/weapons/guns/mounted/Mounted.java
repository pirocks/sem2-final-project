package engine.tools.weapons.guns.mounted;

import engine.tools.weapons.guns.Gun;
import engine.tools.weapons.guns.GunInitialConstants;

/**
 * Created by bob on 4/4/2016.
 *
 */
public abstract class Mounted extends Gun {

	public Mounted(GunInitialConstants gunInitialConstants, int numToolsConstructor) {
		super(gunInitialConstants, numToolsConstructor);
	}
}
