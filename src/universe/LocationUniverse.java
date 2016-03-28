package universe;
import java.math.BigDecimal;
import cities.*;
import planets.*;
import universe.*;
// this class is deprecated

public class LocationUniverse
{
	
	public class CoordinatesUniverse
	{
		private BigDecimal x,y,z;
	}
	CoordinatesUniverse coordinatesUniverse;
	public class CoordinatesPlanet
	{
		private double x,y,z;
	}
	CoordinatesPlanet coordinatesPlanet;
	public class Location
	{
		// private Buildng building;
		// private CityBlock block;
		private int blockx;//really these ints are all I need
		private int blocky;
		// private City city;
		// private Grid grid;
		private int gridx;
		private int gridy;//assert size
		private Planet planet;
		private SolarSystem solarSystem;
		// public Location(Buildng b)
		// {
		// 	// CityBlock block = 
		// }
		// public Location(CityBlock b)
		// {
			
		// }
	}
	Location location;
	
}