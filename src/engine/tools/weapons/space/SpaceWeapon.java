package engine.tools.weapons.space;

import engine.tools.AttackableConstants;
import engine.tools.weapons.Weapon;
import javafx.scene.image.Image;

/**
 * Created by bob on 4/4/2016.
 *
 */
public abstract class SpaceWeapon extends Weapon {
	public double range;
	public SpaceWeapon(AttackableConstants attackableConstants, double damage, double range, int numToolsConstructor) {
		super(attackableConstants,damage, range, numToolsConstructor);
		this.range = range;
	}

	@Override
	public Image getImage() {
		return null;
	}
}
