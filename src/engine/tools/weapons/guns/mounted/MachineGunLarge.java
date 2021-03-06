package engine.tools.weapons.guns.mounted;

import engine.tools.weapons.guns.GunInitialConstants;
import engine.universe.Resource;
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

	public MachineGunLarge(int numToolsConstructor) {
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
		return 5;
	}
}
