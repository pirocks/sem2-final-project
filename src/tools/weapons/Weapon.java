package tools.weapons;

import tools.Tool;

public class Weapon
{
	//one weapon per soldier, regarrdless of soldier population

	protected double damage;
	public Weapon(Tool.Type type)
	{
		
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