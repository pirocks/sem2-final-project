package engine.tools.weapons.guns.mounted;

import engine.tools.weapons.guns.GunInitialConstants;
import engine.universe.ResourceDemand;

/**
 * Created by bob on 4/3/2016.
 *
 */
public class MachineGunLarge extends MachineGun {
	public static double startHealthInitial = 4000;
	public static double resistanceInitial = 1000;
	public static double accuracyInitial = 0.5;
	public static double damageInitial = 5760;
	public static double rangeInitial = 4;

	public MachineGunLarge() {
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
		return null;// TODO: 4/8/2016
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
