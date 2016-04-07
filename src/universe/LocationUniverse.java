package universe;

import planets.LocationPlanet;
import planets.Planet;

import java.math.BigDecimal;

/**
 * Created by bob on 4/7/2016.
 *
 */
public class LocationUniverse
{
	private BigDecimal x,y,z;
	private LocationPlanet localLocation;
	private Planet planet;
	private SolarSystem solarSystem;
	public LocationUniverse(LocationPlanet localLocation)
	{
		this.localLocation = localLocation;
	}
	public LocationUniverse(Planet planet)
	{
		this.planet = planet;
	}
	public void leavePlanet()
	{
		Planet p = localLocation.getPlanet();
		localLocation = null;

	}
	//todo figure this out
