package engine.planets;
// import java.math.BigDecimal;

import engine.buildings.Building;
import engine.cities.City;
import engine.cities.CityBlock;

import java.io.Serializable;
import java.util.Objects;

public class LocationPlanet implements Serializable,PlanetContainer
{
	public Planet planet;
	private int Gridx;
	private int Gridy;
	private int Blockx;
	private int Blocky;
	public LocationPlanet(Planet planet,int Gridx,int Gridy,int Blockx,int Blocky){
		this.planet = planet;
		this.Blockx = Blockx;
		this.Blocky = Blocky;
		this.Gridx = Gridx;
		this.Gridy = Gridy;
	}
	public LocationPlanet(CityBlock b) {
		registerPlanetContainer();
		Blockx = b.getXInGrid();
		Blocky = b.getYInGrid();
		Gridx = b.getGrid().getX();
		Gridy = b.getGrid().getY();
		Planet planet = b.getGrid().getParentPlanet();
	}
	public LocationPlanet(City c) {
		Gridx = c.getGrid().getX();
		Gridy = c.getGrid().getY();
		planet = c.getGrid().getParentPlanet();
		Blockx = c.getCapitalBuilding().getParentBlock().getXInGrid();// TODO: 4/9/2016 see below
		Blocky = c.getCapitalBuilding().getParentBlock().getYInGrid();// TODO: 4/9/2016 make sure that this gets the town hal not capital city and tht get y in grid gets cityblock
	}
	public LocationPlanet(Building b)
	{
		this(b.getParentBlock());
	}

	public LocationPlanet(Grid parentGrid, int centerx, int centery) {
		planet = parentGrid.getParentPlanet();
		Blockx = centerx;
		Blocky = centery;
	}

	public void moveBlock(int x,int y) {
		Blockx = x;
		Blocky = y;
	}
	public void moveGrid(int x, int y) {
		assert(Math.abs(Gridx - x) < 2 && Math.abs(Gridy - y) < 2 );
		Gridx = x;
		Gridy = y;
	}
	public void leavePlanet() {
		planet = null;
		Gridx = -1;
		Gridy = -1;
		Blockx = -1;
		Blocky = -1;
	}
	public void arrivePlanet(CityBlock b) {
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
	public double distanceBetween(LocationPlanet loc) {
		double x1 = (double)(Gridx*100 + Blockx);
		double x2 = (double)(loc.getGridx()*100 + loc.getBlockx());
		double y1 = (double)(Gridy*100 + Blocky);
		double y2 = (double)(loc.getGridy()*100 + loc.getBlocky());
		double dx = x1 - x2;
		double dy = y1 - y2;
		return Math.sqrt(dx*dx+dy*dy);
	}
	private LocationPlanet go(LocationPlanet loc) {
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
	public Planet getPlanet() {return planet;}
	@Override
	public void remove(Planet planet) {
		if(this.planet == planet)
		{
			this.planet = null;
			assert(false);
		}
	}
	public static LocationPlanet mediumLocation(LocationPlanet a,LocationPlanet b) {
		assert (a.getPlanet() ==  b.getPlanet());
		int Gridxa = a.getGridx();
		int Gridya = a.getGridy();
		int Blockxa = a.getBlockx();
		int Blockya = a.getBlocky();
		int Gridxb = b.getGridx();
		int Gridyb = b.getGridy();
		int Blockxb = b.getBlockx();
		int Blockyb = b.getBlocky();
		int Gridxmid = (Gridxa + Gridxb)/2;
		int Gridymid = (Gridya + Gridyb)/2;
		int Blockxmid = (Blockxa + Blockxb)/2;
		int Blockymid = (Blockya + Blockyb)/2;
		LocationPlanet out = new LocationPlanet(a.getPlanet(),Gridxmid,Gridymid,Blockxmid,Blockymid);
		return out;
	}
	public Grid getGrid()
	{
		return planet.getGrids()[Gridy][Gridx];
	}
//	public CityBlock getCityBlock()
//	{
//		return planet.getGrids()[Gridy][Gridx];
//	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof LocationPlanet) {
			LocationPlanet toTest = (LocationPlanet) obj;
			if(toTest.getBlocky() ==  getBlocky()&& toTest.getBlockx() == getBlockx() && toTest.getGridy() == getGridy() && toTest.getGridx() == getGridx() && toTest.getPlanet() == getPlanet())
				return true;
		}
		return false;
	}
}