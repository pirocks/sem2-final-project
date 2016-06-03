package engine.tools.vehicles;

import engine.cities.City;
import engine.planets.LocationPlanet;
import engine.planets.TerrainType;
import engine.tools.vehicles.land.LandVehicle;
import engine.universe.Country;
import engine.universe.Resource;
import engine.universe.ResourceDemand;
import javafx.scene.image.Image;

import static engine.universe.Resource.Type.*;

/**
 * Created by bob on 5/23/2016.
 */
public class CityBuilder extends LandVehicle {
	private Country parentCountry;
	private Resource resource;
	public CityBuilder(LocationPlanet locationPlanet, Country parentCountry) {
		super(new VehicleInitialConstants(locationPlanet,1,1,1000,100000), 1);
		locationPlanet.getGrid().setTerrainType(TerrainType.Land);
		this.parentCountry = parentCountry;
resource = new Resource(new Resource.Type[]{
					Wood, Iron, Oil //// 5/23/2016 add more as necessary
			},new Double[]{
					100.0,100.0,100.0
			});
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
		return 10;
	}
	@Override
	public Image getImage() {
		return new Image(getClass().getResourceAsStream("CityBuilderConstructionSite.jpg"));
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
	public void buildCity() {
		City city = new City(this);
	}
	@Override
	public boolean sanityCheck() {
		return false;
	}
	public Resource getResource() {
		return resource;
	}
	@Override
	public void die() {
		super.die();
		getGrid().vehicleLeaves(this);
	}
}
