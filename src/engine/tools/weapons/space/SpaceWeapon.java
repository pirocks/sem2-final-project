package engine.tools.weapons.space;

import engine.tools.ToolInitialConstants;
import engine.tools.weapons.Weapon;

import java.math.BigDecimal;

/**
 * Created by bob on 4/4/2016.
 *
 */
public abstract class SpaceWeapon extends Weapon {
	public BigDecimal range;
	public SpaceWeapon(ToolInitialConstants toolInitialConstants,double damage, BigDecimal range) {
		super(toolInitialConstants,damage);
		this.range = range;
	}
}
