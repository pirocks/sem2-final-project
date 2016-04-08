package engine.tools.weapons.space;

import engine.universe.ResourceDemand;

/**
 * Created by bob on 4/6/2016.
 *
 */
public class SpaceMissile extends SpaceWeapon {


	public SpaceMissile(double damage, double resistance, double startHealth) {
		super(damage, resistance, startHealth);
	}

	@Override
	public ResourceDemand requiredResourcesForConstruction() {
		return null;// TODO: 4/8/2016
	}

	@Override
	public long constructionManHours() {
		return 0;// TODO: 4/8/2016
	}

	@Override
	public double getWeight() {
		return 0;// TODO: 4/8/2016
	}
}
