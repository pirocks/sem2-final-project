package engine.tools;

import engine.planets.LocationPlanet;
import engine.tools.vehicles.Weighable;
import engine.tools.weapons.Attackable;
import engine.universe.ResourceDemand;

public abstract class Tool implements Weighable, Attackable
{
	private AttackableConstants attackableConstants;
	protected Tool(AttackableConstants attackableConstants)
	{
		this.attackableConstants = attackableConstants;
		//TODO think of sme code to put here
		//what about construction costs
		//constructor from a another class
	}
	public abstract boolean vehicleQ();
	public abstract boolean weaponQ();
	public abstract ResourceDemand requiredResourcesForConstruction();
	public abstract long constructionManHours();//doesn't need o be abstract
	@Override
	public boolean receiveDamage(double damage) {
		return attackableConstants.receiveDamage(damage, this);
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