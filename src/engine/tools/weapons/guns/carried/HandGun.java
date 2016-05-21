package engine.tools.weapons.guns.carried;

import engine.tools.weapons.guns.GunInitialConstants;
import engine.universe.ResourceDemand;

/**
 * Created by bob on 4/3/2016.
 *
 */
public class HandGun extends Carried{
	public static double startHealthInitial = 2;
	public static double resistanceInitial = 0;
	public static double accuracyInitial = 0.5;
	public static double damageInitial = 500;
	public static double rangeInitial = 2;
	public HandGun() {
		super(new GunInitialConstants(
			startHealthInitial,
			resistanceInitial,
			accuracyInitial,
			rangeInitial,
			damageInitial
		));
	}
	@Override
	public ResourceDemand requiredResourcesForConstruction() {
		return null; // TODO: 4/8/2016
	}

	@Override
	public long getManDaysForConstruction() {
		return 0;// TODO: 4/8/2016
	}

	@Override
	public double getWeight() {
		return 0;// TODO: 4/8/2016
	}
}
