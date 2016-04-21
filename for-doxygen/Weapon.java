package engine.tools.weapons;

import engine.tools.AttackableConstants;
import engine.tools.Tool;

public abstract class Weapon extends Tool
{
	//one weapon per soldier, regarrdless of soldier population

	private final double damage;
	public Weapon(AttackableConstants attackableConstants, double damage)
	{
		super(attackableConstants);
		this.damage = damage;
//		if(this instanceof )//maybe use this
		//todo do nothing
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
		target.receiveDamage(damage);
	}
}