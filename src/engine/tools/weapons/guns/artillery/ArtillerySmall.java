package engine.tools.weapons.guns.artillery;

import engine.tools.weapons.guns.GunInitialConstants;
import engine.universe.ResourceDemand;

/**
 * Created by bob on 4/3/2016.
 *
 */
public class ArtillerySmall extends Artillery{
	public static double startHealthInitial = 2000;
	public static double resistanceInitial = 1000;
	public static double accuracyInitial = 0.9;
	public static double damageInitial = 10000;
	public static double rangeInitial = 50;

	public ArtillerySmall(int numToolsConstructor) {
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
	public double getConstructionManDays() {
		return 1 * getNumTools();
	}
}
