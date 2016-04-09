package engine.tools;

import engine.planets.LocationPlanet;
import engine.tools.vehicles.Weighable;
import engine.tools.weapons.Attackable;
import engine.tools.weapons.Weapon;
import engine.universe.ResourceDemand;

public abstract class Tool implements Attackable, Weighable
{
	private double health;
	private double resistance;
	protected Tool(ToolInitialConstants toolInitialConstants)
	{

		health = toolInitialConstants.healthInitial;
		resistance = toolInitialConstants.resistanceInitial;
		//TODO think of sme code to put here
		//what about construction costs
		//constructor from a another class
	}
//	public final Type type;
	public abstract boolean vehicleQ();
	public abstract boolean weaponQ();
	public abstract ResourceDemand requiredResourcesForConstruction();
	public abstract long constructionManHours();//doesn't need o be abstract
	@Override
	public void receiveDamage(double damage, Weapon attacker) {
		health -= damage/resistance;
	}

	@Override
	public void die() {
		// TODO: 4/8/2016 not sure if should be herer
	}

	@Override
	public LocationPlanet getLocationPlanet() {
		return null;// TODO: 4/8/2016
	}
}