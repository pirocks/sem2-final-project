package planets;
// import java.math.BigDecimal;
import planets.*;
import cities.*;

public final class LocationPlanet
{
	public Planet planet;
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
		cityBlock.getGrid().getParentPlanet();
	}
	public LocationPlanet(Building b)
	{
		this(b.getParentBlock());
	}
	public void moveBlock(int x,int y)
	{
		Blockx = x;
		Blocky = y;
	}
	public void moveGrid(int x, int y)
	{
		assert(Math.abs(Gridx - x) < 2 && Math.abs(Gridy - y) < 2 );
		Gridx = x;
		Gridy = y;
	}
}