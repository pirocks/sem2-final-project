package engine.tools.weapons.guns.mounted;

import engine.tools.weapons.guns.GunInitialConstants;
import engine.universe.ResourceDemand;

/**
 * Created by bob on 4/3/2016.
 *
 */
public class MachineGunSmall extends MachineGun {
	public static double startHealthInitial = 500;
	public static double resistanceInitial = 250;
	public static double accuracyInitial = 0.5;
	public static double damageInitial = 1440;
	public static double rangeInitial = 1.5;

	public MachineGunSmall() {
		super(new GunInitialConstants(
			startHealthInitial,
			resistanceInitial,
			accuracyInitial,
			rangeInitial,
			damageInitial
		), numToolsConstructor);
	}

	@Override
	public ResourceDemand requiredResourcesForConstruction() {
		return null;// TODO: 4/8/2016
	}

	@Override
	public double getconstructionManDays() {
		return 0;
	}

	@Override
	public double getWeight() {
		return 0;// TODO: 4/8/2016
	}
}
