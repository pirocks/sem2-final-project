package tools.weapons;

public class Weapon implements Attackable
{
	//one weapon per soldier, regarrdless of soldier population
	private double health;
	private double resistance;
	private final double damage;
	public Weapon(double damage,double resistance,double startHealth)
	{
		this.damage = damage;
		health = startHealth;
		this.resistance = resistance;
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

	@Override
	public void receiveDamage(double damage, Weapon attacker) {
		health -= damage/resistance;
	}
}