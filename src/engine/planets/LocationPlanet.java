package engine.planets;
// import java.math.BigDecimal;

import engine.buildings.Building;
import engine.cities.City;
import engine.cities.CityBlock;
import engine.cities.Container;
import engine.tools.weapons.Attackable;

import java.io.Serializable;

public class LocationPlanet implements Serializable,Container
{
	private Planet planet;
	private int gridx;
	private int gridy;
	private int blockx;
	private int blocky;
	public LocationPlanet(Planet planet,double x,double y){
		if(planet == null)
			throw new IllegalArgumentException();
		this.planet = planet;
		registerContainer(planet);
		blockx = (int) (x % 100);
		blocky = (int) (y % 100);
		gridx = (int) (x /100);
		gridy = (int) (y/100);
	}
	public LocationPlanet(Planet planet,int Gridx,int Gridy,int Blockx,int Blocky){
		this.planet = planet;
		this.blockx = Blockx;
		this.blocky = Blocky;
		this.gridx = Gridx;
		this.gridy = Gridy;
	}
	public LocationPlanet(CityBlock b) {
		blockx = b.getXInGrid();
		blocky = b.getYInGrid();
		gridx = b.getGrid().getX();
		gridy = b.getGrid().getY();
		Planet planet = b.getGrid().getParentPlanet();
		if(planet  == null)
			throw new IllegalArgumentException();
		registerContainer(planet);
	}
	public LocationPlanet(City c) {
		gridx = c.getGrid().getX();
		gridy = c.getGrid().getY();
		planet = c.getGrid().getParentPlanet();
		blockx = c.getCapitalBuilding().getParentBlock().getXInGrid();// TODO: 4/9/2016 see below
		blocky = c.getCapitalBuilding().getParentBlock().getYInGrid();// TODO: 4/9/2016 make sure that this gets the town hal not capital city and tht getImage y in grid gets cityblock
		if(planet == null)
			throw new IllegalArgumentException();
		registerContainer(planet);
	}
	public LocationPlanet(Building b) {
		this(b.getParentBlock());
		if(b.getParentBlock().getParentGrid().getParentPlanet() == null)
			throw new IllegalArgumentException();
	}
	public LocationPlanet(Grid parentGrid, int centerX, int centerY) {
		planet = parentGrid.getParentPlanet();
		gridx = parentGrid.getX();
		gridy = parentGrid.getY();
		blockx = centerX;
		blocky = centerY;
		if(planet == null)
			throw new IllegalArgumentException();
		registerContainer(planet);
	}
	public LocationPlanet(LocationPlanet locationPlanet){
		planet = locationPlanet.getPlanet();
//		if(planet == null)// TODO: 5/29/2016 fix this bug
//			throw new IllegalArgumentException();
		gridx = locationPlanet.getGridx();
		gridy = locationPlanet.getGridy();
		blockx = locationPlanet.getBlockx();
		blocky = locationPlanet.getBlocky();
	}
	public double getLocNumX(){
		return 100*getGridx() + blockx;
	}
	public double getLocNumY(){
		return 100*getGridy() + blocky;
	}
	public void arrivePlanet(CityBlock b) {
		assert(planet == null);
		blockx = b.getXInGrid();
		blocky = b.getYInGrid();
		gridx = b.getGrid().getX();
		gridy = b.getGrid().getY();
		planet = b.getGrid().getParentPlanet();
		registerContainer(planet);
	}
	public double distanceBetween(LocationPlanet loc) {
		double x1 = (double)(gridx *100 + blockx);
		double x2 = (double)(loc.getGridx()*100 + loc.getBlockx());
		double y1 = (double)(gridy *100 + blocky);
		double y2 = (double)(loc.getGridy()*100 + loc.getBlocky());
		double dx = x1 - x2;
		double dy = y1 - y2;
		return Math.sqrt(dx*dx+dy*dy);
	}
	private LocationPlanet go(LocationPlanet loc) {
		gridx = loc.getGridx();
		gridy = loc.getGridy();
		blockx = loc.getBlockx();
		blocky = loc.getBlocky();
		return this;
	}
	//force arrival is hacky. todo fix later by changing ints to doubles in internal representation
	//there are some places that you cannot go. need to check for that.
	public LocationPlanet goTowards(LocationPlanet loc,double d,boolean forceArrival,boolean canGoInWater,boolean
			canGoInSpace) throws InTheOceanException {
		if(canGoInSpace)
			throw new IllegalStateException();
		if(loc.getPlanet() != planet)
			throw new IllegalStateException();
		if(forceArrival)
			return go(loc);
		double percent = d/this.distanceBetween(loc);
		if(percent > 1.0){
			return go(loc);
		}
		double startX = getLocNumX();
		double startY = getLocNumY();
		double endX = loc.getLocNumX();
		double endY = loc.getLocNumY();
		double dx = (endX - startX)*percent;
		double dy = (endY - startY)*percent;
		double x = startX + dx;
		double y = startY + dy;
		LocationPlanet result = new LocationPlanet(loc.getPlanet(),x,y);
		if(result.getGrid().getTerrainType() == TerrainType.Sea)
			throw new InTheOceanException(result.getGrid());
		go(result);
		return result;
	}
	public int getGridx()
	{
		return gridx;
	}
	public int getGridy()
	{
		return gridy;
	}
	public int getBlockx()
	{
		return blockx;
	}
	public int getBlocky()
	{
		return blocky;
	}
	public Planet getPlanet() {return planet;}
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
	public Grid getGrid() {
		return planet.getGrids()[gridy][gridx];
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
	@Override
	public void remove(Attackable attackable) {
		if(attackable instanceof Planet && planet == attackable)
			planet = null;
		else
			throw new IllegalStateException();
	}
	public void setPlanet(Planet planet) {
		if(this.planet != null)
			deregisterContainer(this.planet);
		this.planet = planet;
		registerContainer(planet);
	}
	public class InTheOceanException extends Exception {
		private Grid grid;
		/**
		 * Constructs a new exception with {@code null} as its detail message.
		 * The cause is not initialized, and may subsequently be initialized by a
		 * call to {@link #initCause}.
		 * @param grid
		 */
		public InTheOceanException(Grid grid) {
			super();
			this.grid = grid;
		}
	}
	public void moveBlock(int x,int y) {
		blockx = x;
		blocky = y;
	}
	public void moveGrid(int x, int y) {
		assert(Math.abs(gridx - x) < 2 && Math.abs(gridy - y) < 2 );
		gridx = x;
		gridy = y;
	}
	public void leavePlanet() {
		deregisterContainer(planet);
		planet = null;
		gridx = -1;
		gridy = -1;
		blockx = -1;
		blocky = -1;
	}
	public void arrivePlanet(Building b)
	{
		arrivePlanet(b.getParentBlock());
	}

	@Override
	public String toString() {
		return "gridx" + gridx + "gridy" + gridy + "blockx:" + blockx + "blocky" + blocky;
	}
}