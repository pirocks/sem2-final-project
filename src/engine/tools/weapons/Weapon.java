package engine.tools.weapons;

import engine.tools.AttackableConstants;
import engine.tools.Tool;

public abstract class Weapon extends Tool
{
	//one weapon per soldier, regarrdless of soldier population

	private final double damage;
	private final double range;

	public Weapon(AttackableConstants attackableConstants, double damage, double range, int numToolsConstructor)
	{
		super(attackableConstants, numToolsConstructor);
		this.damage = damage;
		this.range = range;
	}
	public boolean weaponQ()
	{
		return true;
	}
	public boolean vehicleQ()
	{
		return false;
	}
	public void attack(Attackable target)
	{
		target.receiveDamage(damage,this);
	}

	public double getRange() {
		return range;
	}
}