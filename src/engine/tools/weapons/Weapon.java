package engine.tools.weapons;

import engine.tools.AttackableConstants;
import engine.tools.Tool;

public abstract class Weapon extends Tool
{
	//one weapon per soldier, regarrdless of soldier population

	private final double damage;
	private double range;

	public Weapon(AttackableConstants attackableConstants, double damage, double range)
	{
		super(attackableConstants);
		this.damage = damage;
//		if(this instanceof )//maybe use this
		//todo do nothing
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
	public void die()
	{
		assert (amIDead());
		WeaponContainer.killWeapon(this);
	}
}