package engine.tools.vehicles.space.cityship;

import engine.planets.LocationPlanet;
import engine.tools.AttackableConstants;
import engine.tools.vehicles.VehicleInitialConstants;
import engine.tools.vehicles.space.asteroidminer.AsteroidMinerSmall;
import engine.universe.Resource;
import engine.universe.ResourceDemand;

import static engine.universe.Resource.Type.*;

/**
 * Created by bob on 4/7/2016.
 */
public class CityShipSmall extends CityShip
{
	public static int maxPassengersInitial = AsteroidMinerSmall.maxPassengersInitial*2;
	public static double maxWeightInitial = AsteroidMinerSmall.maxWeightInitial*2;
	public static double startHealthInitial = AsteroidMinerSmall.startHealthInitial/2;
	public static double resistanceInitial = AsteroidMinerSmall.resistanceInitial/2;


	protected CityShipSmall(LocationPlanet locationPlanet, int numToolsConstructor) {
		super(new VehicleInitialConstants(new AttackableConstants(startHealthInitial,resistanceInitial,
				locationPlanet),maxPassengersInitial,maxWeightInitial),numToolsConstructor);
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
