package engine.tools.weapons.guns.carried;

import engine.tools.weapons.guns.GunInitialConstants;
import engine.universe.ResourceDemand;

/**
 * Created by bob on 4/3/2016.
 *
 */
public class SniperRifle extends Carried{
	public static double startHealthInitial = 2;
	public static double resistanceInitial = 0;
	public static double accuracyInitial = 0.9;
	public static double damageInitial = 100;
	public static double rangeInitial = 100;

	public SniperRifle(int numToolsConstructor) {
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
		return null;// TODO: 5/22/2016
	}

	@Override
	public double getconstructionManDays() {
		return 0;// TODO: 5/22/2016
	}
}
