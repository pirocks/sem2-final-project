package engine.tools.weapons.guns.artillery;

import engine.tools.weapons.guns.Gun;
import engine.tools.weapons.guns.GunInitialConstants;
import javafx.scene.image.Image;

/**
 * Created by bob on 4/3/2016.
 *
 */
public abstract class Artillery extends Gun {

	public Artillery(GunInitialConstants gunInitialConstants, int numToolsConstructor) {
		super(gunInitialConstants, numToolsConstructor);
	}

	@Override
	public Image getImage() {
		return null;
	}
}
