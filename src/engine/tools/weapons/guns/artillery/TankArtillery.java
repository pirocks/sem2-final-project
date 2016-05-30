package engine.tools.weapons.guns.artillery;

import engine.tools.weapons.guns.GunInitialConstants;
import engine.universe.Resource;
import engine.universe.ResourceDemand;

/**
 * Created by bob on 4/3/2016.
 *
 */
public class TankArtillery extends Artillery {
	public static double startHealthInitial = ArtilleryMedium.startHealthInitial/3;
	public static double resistanceInitial = ArtilleryMedium.resistanceInitial/3;
	public static double accuracyInitial = ArtilleryMedium.accuracyInitial;
	public static double damageInitial = ArtilleryMedium.damageInitial;
	public static double rangeInitial = ArtilleryMedium.rangeInitial/1.3;

	public TankArtillery(int numToolsConstructor) {
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
