package universe;
import java.math.BigDecimal;
import cities.*;
import planets.*;
import universe.*;


public class LocationUniverse
{
	public class Coordinates
	{
		private BigDecimal x,y,z;
	}
	Coordinates coordinates;
	public class Location
	{
		private Building building;
		private City city;
		private Grid grid;
		private Planet planet;
		private SolarSystem solarSystem;
	}
	Location location;
}