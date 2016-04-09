package engine.tools.weapons.guns.carried;

import engine.universe.ResourceDemand;

/**
 * Created by bob on 4/3/2016.
 *
 */
public class SniperRifle extends Carried{
	public static double startHealthInitial;
	public static double resistanceInitial;
	public static double accuracyInitial;
	public static double damageInitial;
	public static double rangeInitial;

	public SniperRifle() {
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
