package engine.tools.weapons.guns.mounted;

import engine.tools.weapons.guns.GunInitialConstants;
import engine.universe.Resource;
import engine.universe.ResourceDemand;
import javafx.scene.image.Image;

/**
 * Created by bob on 4/3/2016.
 *
 */
public class MachineGunSmall extends MachineGun {
	public static double startHealthInitial = 500;
	public static double resistanceInitial = 250;
	public static double accuracyInitial = 0.5;
	public static double damageInitial = 1440;
	public static double rangeInitial = 1.5;

	public MachineGunSmall(int numToolsConstructor) {
		super(new GunInitialConstants(startHealthInitial, resistanceInitial, accuracyInitial, rangeInitial, damageInitial), numToolsConstructor);
	}

	@Override
	public Image getImage() {
		return new Image(getClass().getResourceAsStream("machinegun.jpg"));
	}

	@Override
	public ResourceDemand requiredResourcesForConstruction() {
		return new ResourceDemand(new Resource.Type[]{Resource.Type.Iron}, startHealthInitial, resistanceInitial, damageInitial, rangeInitial, accuracyInitial);
	}

	@Override
	public double getConstructionManDays() {
		return 1.5;
	}

}
