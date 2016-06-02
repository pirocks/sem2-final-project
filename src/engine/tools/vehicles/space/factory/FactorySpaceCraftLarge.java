package engine.tools.vehicles.space.factory;

import engine.planets.LocationPlanet;
import engine.tools.AttackableConstants;
import engine.tools.vehicles.VehicleInitialConstants;
import engine.tools.vehicles.space.cityship.CityShipMedium;
import engine.universe.ResourceDemand;

/**
 * Created by bob on 4/7/2016.
 *
 */
public class FactorySpaceCraftLarge extends FactorySpaceCraft
{
	public static int maxPassengersInitial = CityShipMedium.maxPassengersInitial ;
	public static double maxWeightInitial = CityShipMedium.maxWeightInitial ;
	public static double startHealthInitial = CityShipMedium.startHealthInitial ;
	public static double resistanceInitial = CityShipMedium.resistanceInitial ;

	protected FactorySpaceCraftLarge(LocationPlanet locationPlanet, int numToolsConstructor) {
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
