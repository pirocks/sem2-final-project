package engine.tools.weapons.guns.mounted;

/**
 * Created by bob on 4/3/2016.
 */
public abstract class MachineGun extends Mounted {

	public MachineGun(double accuracy, double damage, double range, double resistance, double startHealth) {
		super(accuracy, damage, range, resistance, startHealth);
	}
}
