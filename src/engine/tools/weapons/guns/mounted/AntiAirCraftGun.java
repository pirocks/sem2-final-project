package engine.tools.weapons.guns.mounted;

import engine.tools.weapons.guns.GunInitialConstants;
import engine.universe.ResourceDemand;
import javafx.scene.image.Image;

/**
 * Created by bob on 4/3/2016.
 *
 */
public class AntiAirCraftGun extends Mounted {

	public static double startHealthInitial;// TODO: 5/22/2016
	public static double resistanceInitial;// TODO: 5/22/2016
	public static double accuracyInitial;// TODO: 5/22/2016
	public static double damageInitial;// TODO: 5/22/2016
	public static double rangeInitial;// TODO: 5/22/2016

	public AntiAirCraftGun(int numToolsConstructor) {
		super(new GunInitialConstants(startHealthInitial,resistanceInitial,accuracyInitial,rangeInitial,damageInitial),numToolsConstructor);
	}


	@Override
	public Image getImage() {
		return new Image(getClass().getResourceAsStream("ntiaircraftgun.jpg"));
	}

	@Override
	public ResourceDemand requiredResourcesForConstruction() {
		return null;// TODO: 5/22/2016
	}

	@Override
	public double getConstructionManDays() {
		return 0;// TODO: 5/22/2016
	}
}
