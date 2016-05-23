package engine.tools.weapons.space;

import engine.planets.LocationPlanet;
import engine.tools.AttackableConstants;
import engine.universe.ResourceDemand;

/**
 * Created by bob on 4/6/2016.
 *
 */
public class SpaceMissile extends SpaceWeapon {


	public static double startHealthInitial;
	public static double resistanceInitial;
	public static double damageInitial;
	public static double rangeInitial;

	public SpaceMissile(LocationPlanet location, int numToolsConstructor) {
		super(new AttackableConstants(startHealthInitial,resistanceInitial,location),damageInitial,rangeInitial, numToolsConstructor);
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
