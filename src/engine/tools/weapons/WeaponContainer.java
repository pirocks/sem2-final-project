package engine.tools.weapons;

import java.util.ArrayList;

/**
 * Created by bob on 4/5/2016.
 *
 */
public interface WeaponContainer
{
	// TODO: 5/24/2016
	void remove(Weapon weapon);
	default void registerWeaponContainer()
	{
		registerContainer(this);
	}
	ArrayList<WeaponContainer> containers = new ArrayList<>();
	static void registerContainer(WeaponContainer in)
	{
		containers.add(in);
	}
	static void killWeapon(Weapon in)
	{
		for(WeaponContainer weaponContainer :containers)
		{
			weaponContainer.remove(in);
		}
	}
}
