package engine.tools.weapons.guns.artillery;

import engine.tools.weapons.guns.GunInitialConstants;
import engine.universe.ResourceDemand;

/**
 * Created by bob on 4/3/2016.
 *
 */
public class ArtilleryMedium extends Artillery{
	public static double startHealthInitial = 8000;
	public static double resistanceInitial = 4000;
	public static double accuracyInitial = 0.5;
	public static double damageInitial = 30000;
	public static double rangeInitial = 200;

	public ArtilleryMedium(int numToolsConstructor) {
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
