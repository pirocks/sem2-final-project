package engine.tools.weapons.guns.mounted;

import engine.tools.weapons.guns.GunInitialConstants;
import engine.universe.Resource;
import engine.universe.ResourceDemand;
import javafx.scene.image.Image;

/**
 * Created by bob on 4/3/2016.
 *
 */
public class AntiAirCraftGun extends Mounted {

	public static double startHealthInitial = MachineGunLarge.startHealthInitial;
	public static double resistanceInitial = MachineGunLarge.resistanceInitial;
	public static double accuracyInitial = 0.9;
	public static double damageInitial = MachineGunMedium.damageInitial;
	public static double rangeInitial = MachineGunLarge.rangeInitial*2;

	public AntiAirCraftGun(int numToolsConstructor) {
		super(new GunInitialConstants(startHealthInitial,resistanceInitial,accuracyInitial,rangeInitial,damageInitial),numToolsConstructor);
	}


	@Override
	public Image getImage() {
		return new Image(getClass().getResourceAsStream("antiaircraftgun.jpg"));
	}

	@Override
	public ResourceDemand requiredResourcesForConstruction() {
		return new ResourceDemand(new Resource.Type[] {Resource.Type.Iron},startHealthInitial,resistanceInitial,damageInitial,rangeInitial,accuracyInitial);
	}

	@Override
	public double getConstructionManDays() {
		return 3.5;
	}
}
