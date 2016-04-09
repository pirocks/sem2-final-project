package engine.tools.weapons.guns.artillery;

import engine.universe.ResourceDemand;

/**
 * Created by bob on 4/3/2016.
 *
 */
public class ArtilleryMedium extends Artillery{
	public static double startHealthInitial;
	public static double resistanceInitial;
	public static double accuracyInitial;
	public static double damageInitial;
	public static double rangeInitial;

	public ArtilleryMedium() {
		super(accuracyInitial, damageInitial, rangeInitial, resistanceInitial, startHealthInitial);
	}
	@Override
	public ResourceDemand requiredResourcesForConstruction() {
		return null;// TODO: 4/8/2016
	}

	@Override
	public long constructionManHours() {
		return 0;// TODO: 4/8/2016
	}

	@Override
	public double getWeight() {
		return 0;// TODO: 4/8/2016
	}
}
