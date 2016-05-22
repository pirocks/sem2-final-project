package engine.tools.weapons.guns.artillery;

import engine.tools.weapons.guns.GunInitialConstants;
import engine.universe.ResourceDemand;

/**
 * Created by bob on 4/3/2016.
 */
public class Howitzer extends Artillery{
	public static double startHealthInitial = 8000;
	public static double resistanceInitial = 4000;
	public static double accuracyInitial = 0.9;
	public static double damageInitial = 16666.66666666666666666667;
	public static double rangeInitial = 6000/50;

	public Howitzer(int numToolsConstructor) {
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
