package engine.tools;

import engine.planets.LocationPlanet;
import engine.tools.vehicles.Weighable;
import engine.tools.weapons.Attackable;
import engine.tools.weapons.Weapon;
import engine.universe.ResourceDemand;

public abstract class Tool extends Attackable implements Weighable
{
	protected Tool(AttackableInitialConstants attackableInitialConstants)
	{
		super(attackableInitialConstants);
		//TODO think of sme code to put here
		//what about construction costs
		//constructor from a another class
	}
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