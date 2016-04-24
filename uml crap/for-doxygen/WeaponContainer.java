package engine.tools.weapons;

/**
 * Created by bob on 4/5/2016.
 *
 */
public interface WeaponContainer
{
	void remove(Weapon weapon);
	default void registerWeaponContainer()
	{
		WeaponContainers.registerContainer(this);
	}
}
