package engine.tools.weapons.space;

import engine.planets.LocationPlanet;
import engine.tools.AttackableConstants;
import engine.universe.ResourceDemand;

/**
 * Created by bob on 4/6/2016.
 *
 */
public class EmpWeapon extends SpaceWeapon {
	public static double startHealthInitial;
	public static double resistanceInitial;
	public static double damageInitial;
	public static double rangeInitial;

	public EmpWeapon(LocationPlanet location) {
		super(new AttackableConstants(startHealthInitial,resistanceInitial,location), damageInitial,rangeInitial);
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
