package engine.tools;

import engine.tools.vehicles.Weighable;
import engine.tools.weapons.Attackable;
import engine.tools.weapons.Weapon;
import engine.universe.ResourceDemand;

public abstract class Tool implements Attackable, Weighable
{
	protected double health;
//	protected double resistance;
	protected Tool(double resistance,double startHealth)
	{

		health = startHealth;
		this.resistance = resistance;
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
}