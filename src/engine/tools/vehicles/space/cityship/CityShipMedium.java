package engine.tools.vehicles.space.cityship;

import engine.planets.LocationPlanet;
import engine.tools.AttackableConstants;
import engine.tools.vehicles.VehicleInitialConstants;
import engine.universe.ResourceDemand;

/**
 * Created by bob on 4/7/2016.
 */
public class CityShipMedium extends CityShip
{
	public static int maxPassengersInitial = (int) (CityShipSmall.maxPassengersInitial*1.5);
	public static double maxWeightInitial = CityShipSmall.maxWeightInitial*1.5;
	public static double startHealthInitial = CityShipSmall.startHealthInitial*1.5;
	public static double resistanceInitial = CityShipSmall.resistanceInitial*1.5;

	protected CityShipMedium(LocationPlanet locationPlanet, int numToolsConstructor) {
		super(new VehicleInitialConstants(new AttackableConstants(startHealthInitial,resistanceInitial, locationPlanet),maxPassengersInitial,maxWeightInitial),numToolsConstructor);
	}

	@Override
	public double getSpeed() {
		return 0;// TODO: 5/22/2016
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
