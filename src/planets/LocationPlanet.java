package planets;
// import java.math.BigDecimal;
import planets.*;
import cities.*;

public final class LocationPlanet
{
	Planet planet;
	public int Gridx;
	public int Gridy;
	public int Blockx;
	public int Blocky;
	public LocationPlanet(CityBlock b)
	{
		Blockx = b.getXInGrid();
		Blocky = b.getYInGrid();
		Gridx = b.getGrid().getX();
		Gridy = b.getGrid().getY();
	}
}