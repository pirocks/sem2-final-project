package engine.tools.weapons;

import java.util.ArrayList;

/**
 * Created by bob on 4/5/2016.
 *
 */
public interface WeaponContainer
{
	void remove(Weapon weapon);
	default void registerWeaponContainer()
	{
		registerContainer(this);
	}
	static ArrayList<WeaponContainer> containers = new ArrayList<>();
	public static void registerContainer(WeaponContainer in)
	{
		containers.add(in);
	}
	public static void killWeapon(Weapon in)
	{
		for(WeaponContainer weaponContainer :containers)
		{
			weaponContainer.remove(in);
		}
	}
}
