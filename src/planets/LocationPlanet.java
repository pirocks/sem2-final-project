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
	public void leavePlanet()
	{
		planet = null;
		Gridx = -1;
		Gridy = -1;
		Blockx = -1;
		Blocky = -1;
	}
	public void arrivePlanet(CityBlock b)
	{
		assert(planet == null);
		Blockx = b.getXInGrid();
		Blocky = b.getYInGrid();
		Gridx = b.getGrid().getX();
		Gridy = b.getGrid().getY();
		cityBlock.getGrid().getParentPlanet();

	}
	public void arrivePlanet(Building b)
	{
		arrivePlanet(b.getParentBlock());
	}
	public double distanceBetween(LocationPlanet loc)
	{
		double x1 = (double)(Gridx*100 + Blockx);
		double x2 = (double)(loc.getGridx()*100 + loc.getBlockx());
		double y1 = (double)(Gridy*100 + Blocky);
		double y2 = (double)(loc.getGridy()*100 + loc.getBlocky());
		double dx = x1 - x2;
		double dy = y1 - y2;
		return Math.sqrt(dx*dx+dy*dy);
	}
	public int getGridx()
	{
		return Gridx;
	}
	public int getGridy()
	{
		return Gridy;
	}
	public int getBlockx()
	{
		return Blockx;
	}
	public int getBlocky()
	{
		return Blocky;
	}
}