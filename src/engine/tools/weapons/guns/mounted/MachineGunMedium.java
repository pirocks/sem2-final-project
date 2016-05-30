package engine.tools.weapons.guns.mounted;

import engine.tools.weapons.guns.GunInitialConstants;
import engine.universe.Resource;
import engine.universe.ResourceDemand;

/**
 * Created by bob on 4/3/2016.
 *
 */
public class MachineGunMedium extends MachineGun {
	public static double startHealthInitial = 1000;
	public static double resistanceInitial = 500;
	public static double accuracyInitial = 0.5;
	public static double damageInitial = 2880;
	public static double rangeInitial = 2;

	public MachineGunMedium(int numToolsConstructor) {
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
		return new ResourceDemand(new Resource.Type[] {Resource.Type.Iron},startHealthInitial,resistanceInitial,damageInitial,rangeInitial,accuracyInitial);
	}

	@Override
	public double getConstructionManDays() {
		return 2.5;
	}
}
