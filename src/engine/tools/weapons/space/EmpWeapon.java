package engine.tools.weapons.space;

import engine.planets.LocationPlanet;
import engine.tools.AttackableConstants;
import engine.universe.Resource;
import engine.universe.ResourceDemand;

/**
 * Created by bob on 4/6/2016.
 *
 */
public class EmpWeapon extends SpaceWeapon {
	public static double startHealthInitial;// TODO: 5/22/2016
	public static double resistanceInitial;// TODO: 5/22/2016
	public static double damageInitial;// TODO: 5/22/2016
	public static double rangeInitial;// TODO: 5/22/2016

	public EmpWeapon(LocationPlanet location, int numToolsConstructor) {
		super(new AttackableConstants(startHealthInitial,resistanceInitial,location), damageInitial,rangeInitial,
				numToolsConstructor);
	}


	@Override
	public ResourceDemand requiredResourcesForConstruction() {
		return new ResourceDemand(new Resource.Type[] {Resource.Type.Iron},startHealthInitial,resistanceInitial,damageInitial,rangeInitial,accuracyInitial);
	}

	@Override
	public double getConstructionManDays() {
		return 0;// TODO: 5/22/2016
	}
}
