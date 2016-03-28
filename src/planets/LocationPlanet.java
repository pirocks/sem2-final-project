package planets;
// import java.math.BigDecimal;
import planets.*;
import cities.*;

public class LocationPlanet
{
	Planet planet;
	private int Gridx;
	private int Gridy;
	private int Blockx;
	private int Blocky;
	public LocationPlanet(CityBlock b)
	{
		Blockx = b.getXInGrid();
		Blocky = b.getYInGrid();
		Gridx = b.getGrid().getX();
		Gridy = b.getGrid().getY();
	}
}