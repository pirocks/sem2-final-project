package planets;
// import java.math.BigDecimal;

import buildings.Building;
import cities.CityBlock;

public class LocationPlanet implements PlanetContainer
{
	public Planet planet;
	private int Gridx;
	private int Gridy;
	private int Blockx;
	private int Blocky;
	public LocationPlanet(CityBlock b)
	{
		registerPlanetContainer();
		Blockx = b.getXInGrid();
		Blocky = b.getYInGrid();
		Gridx = b.getGrid().getX();
		Gridy = b.getGrid().getY();
		Planet planet = b.getGrid().getParentPlanet();
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
		Planet planet = b.getGrid().getParentPlanet();

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
	private LocationPlanet go(LocationPlanet loc)
	{
		Gridx = loc.getGridx();
		Gridy = loc.getGridy();
		Blockx = loc.getBlockx();
		Blocky = loc.getBlocky();
		return this;
	}
	//force arrival is hacky. fix later by changing ints to doubles in internal representation
	public LocationPlanet goTowards(LocationPlanet loc,double d,boolean forceArrival)//there are some places that you cannot go. need to check for that.
	{
		if(forceArrival)
			go(loc);
		double percent = d/this.distanceBetween(loc);
		assert(percent <= 1.0);//maybe should be illegal arg do both
		if(percent > 1.0)
			throw new IllegalArgumentException();
		double x1 = (double)(Gridx*100 + Blockx);
		double x2 = (double)(loc.getGridx()*100 + loc.getBlockx());
		double y1 = (double)(Gridy*100 + Blocky);
		double y2 = (double)(loc.getGridy()*100 + loc.getBlocky());
		double dx = percent*(x2 - x1);
		double dy = percent*(y2 - y1);
		double blockAddX = (int)(dx % 100);
		double blockAddY = (int)(dy % 100);
		int GridAddX = (int)(dx/100.0);
		int GridAddY = (int)(dy/100.0);
		if(GridAddX != 0 || GridAddY != 0)
			System.err.println("changing grid");
		Gridx += GridAddX;
		Gridy += GridAddY;
		Blockx += blockAddX;
		Blocky += blockAddY;
		return this;
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

	@Override
	public void remove(Planet planet) {
		if(this.planet == planet)
		{
			this.planet = null;
			assert(false);
		}
	}
}