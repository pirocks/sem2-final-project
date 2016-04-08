package engine.tools.weapons;

import java.util.ArrayList;

/**
 * Created by bob on 4/5/2016.
 *
 */
public class WeaponContainers
{
	private static ArrayList<WeaponContainer> containers = new ArrayList<>();
	public static void registerContainer(WeaponContainer in)
	{
		containers.add(in);
	}
	public static void remove(Weapon in)
	{
		for(WeaponContainer weaponContainer :containers)
		{
			weaponContainer.remove(in);
		}
	}
}
