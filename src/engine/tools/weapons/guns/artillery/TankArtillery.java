package engine.tools.weapons.guns.artillery;

import engine.tools.weapons.guns.GunInitialConstants;
import engine.universe.Resource;
import engine.universe.ResourceDemand;

/**
 * Created by bob on 4/3/2016.
 *
 */
public class TankArtillery extends Artillery {
	public static double startHealthInitial;// TODO: 5/28/2016
	public static double resistanceInitial;// TODO: 5/28/2016
	public static double accuracyInitial;// TODO: 5/28/2016
	public static double damageInitial;// TODO: 5/28/2016
	public static double rangeInitial;// TODO: 5/28/2016

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
