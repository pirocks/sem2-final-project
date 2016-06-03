package engine.tools.vehicles.space.factory;

import engine.planets.LocationPlanet;
import engine.tools.AttackableConstants;
import engine.tools.vehicles.VehicleInitialConstants;
import engine.tools.vehicles.space.cityship.CityShipMedium;
import engine.universe.Resource;
import engine.universe.ResourceDemand;

import static engine.universe.Resource.Type.*;

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
		return new ResourceDemand(new Resource.Type[]{Resource.Type.Iron,Oil,Silicon,Uranium,Water},startHealthInitial,resistanceInitial,maxWeightInitial,maxPassengersInitial);
	}

	@Override
	public double getConstructionManDays() {
		return 0;// TODO: 5/22/2016
	}
}
