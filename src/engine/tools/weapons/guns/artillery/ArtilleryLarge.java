package engine.tools.weapons.guns.artillery;

import engine.tools.weapons.guns.GunInitialConstants;
import engine.universe.ResourceDemand;

/**
 * Created by bob on 4/3/2016.
 *
 */
public class ArtilleryLarge extends Artillery{
	public static double startHealthInitial = 16000;
	public static double resistanceInitial = 8000;
	public static double accuracyInitial = 0.3;
	public static double damageInitial = 75000;
	public static double rangeInitial = 500;

	public ArtilleryLarge(int numToolsConstructor) {
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
		return 0;// TODO: 5/22/2016
	}
}
