package engine.cities;

import engine.planets.Grid;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by user on 4/13/2016.
 *
 */
public class FarmLand implements Serializable //only one per grid
{
	private Grid parentGrid;
	public class Region
	{
		int y;
		int startx;// from 0 to 100
		int endx;

		public boolean contains(int x, int y){
			if(this.y == y)
				if(this.startx <= x || x <= this.endx)
					return true;
			return false;
		}
	}
	private ArrayList<Region> regions = new ArrayList<>();

	public ArrayList<Region> findRegionsOnRow(int y)
	{
		ArrayList<Region> out = new ArrayList<>();
		for(Region region:regions){
			if(region.y == y)
				out.add(region);
		}
		return out;
	}
	public ArrayList<Region> findRegionsOnColumn(int x)
	{
		ArrayList<Region> out = new ArrayList<>();
		for(Region region:regions){
			if(region.startx <= x || x <= region.endx)
				out.add(region);
		}
		return out;
	}
	public boolean contains(int x, int y)
	{
		for(Region region:regions){
			if(region.contains(x,y) == true)
				return true;
		}
		return false;
	}
	public boolean containsRow(int y)
	{
		if(findRegionsOnRow(y).size() > 0)
			return true;
		return false;
	}
	public boolean containsColumn(int x)
	{
		if(findRegionsOnColumn(x).size() > 0)
			return true;
		return false;
	}
}
