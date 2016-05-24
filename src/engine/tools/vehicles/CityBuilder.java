package engine.tools.vehicles;

import engine.planets.LocationPlanet;
import engine.universe.Country;
import engine.universe.Resource;
import engine.universe.ResourceDemand;

import static engine.universe.Resource.Type.*;

/**
 * Created by bob on 5/23/2016.
 */
public class CityBuilder extends Vehicle {
	private final Country parentCountry;

	public CityBuilder(LocationPlanet locationPlanet, Country parentCountry) {
		super(new VehicleInitialConstants(locationPlanet,1,1,1000,100000), 1);
		this.parentCountry = parentCountry;
		try {
			super.loadObject(new Resource(new Resource.Type[]{
					Wood, Iron, Oil //// TODO: 5/23/2016 add more as necesary
			},new Double[]{
					100.0,100.0,100.0
			}));
		} catch (ToHeavyException e) {
			e.printStackTrace();
			throw new IllegalStateException(e);
		}
	}

	@Override
	public boolean inSpaceQ() {
		return false;
	}

	@Override
	public boolean inWaterQ() {
		return false;
	}

	@Override
	public double getSpeed() {
		return 0;
	}

	@Override
	public ResourceDemand requiredResourcesForConstruction() {
		return null;
	}

	@Override
	public double getConstructionManDays() {
		return 0;
	}

	public Country getParentCountry() {
		return parentCountry;
	}
}
