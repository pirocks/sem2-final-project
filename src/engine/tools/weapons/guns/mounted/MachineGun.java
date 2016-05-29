package engine.tools.weapons.guns.mounted;

import engine.tools.weapons.guns.GunInitialConstants;
import javafx.scene.image.Image;

/**
 * Created by bob on 4/3/2016.
 *
 */
public abstract class MachineGun extends Mounted {
	public MachineGun(GunInitialConstants gunInitialConstants, int numToolsConstructor) {
		super(gunInitialConstants, numToolsConstructor);
	}

	@Override
	public Image getImage() {
		return null;
	}
}
