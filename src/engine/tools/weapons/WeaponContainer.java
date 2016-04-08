package engine.tools.weapons;

/**
 * Created by bob on 4/5/2016.
 *
 */
public interface WeaponContainer
{
	public abstract void remove(Weapon weapon);
	default public void register()
	{
		WeaponContainers.registerContainer(this);
	}
}
