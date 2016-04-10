package engine.tools.weapons;

import engine.tools.Tool;
import engine.tools.AttackableInitialConstants;

public abstract class Weapon extends Tool
{
	//one weapon per soldier, regarrdless of soldier population

	private final double damage;
	public Weapon(AttackableInitialConstants attackableInitialConstants, double damage)
	{
		super(attackableInitialConstants);
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
		target.receiveDamage(damage,this);
	}
}