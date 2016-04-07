package tools;

import tools.vehicles.Weighable;
import tools.weapons.Attackable;
import tools.weapons.Weapon;
import universe.ResourceDemand;

public abstract class Tool implements Attackable, Weighable
{
	protected double health;
	protected double resistance;
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