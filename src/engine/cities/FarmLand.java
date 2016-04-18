package engine.cities;

import com.sun.org.apache.regexp.internal.RE;
import engine.planets.Grid;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by user on 4/13/2016.
 *
 */
public class FarmLand implements Serializable //only one per grid
{
	private Grid parentGrid;
	public class Region implements Comparable
	{
		private int y;
		private int startx;// from 0 to 100
		private int endx;
		public Region(int y, int startx, int endx){
			assert(startx <= endx);
			this.y = y;
			this.startx = startx;
			this.endx = endx;
		}

		public boolean contains(int x, int y){
			if(this.y == y)
				if(this.startx <= x || x <= this.endx)
					return true;
			return false;
		}

		@Override
		public int compareTo(Object o) {
			assert (o instanceof Region);
			Region region = (Region) o;
			return 1000*(this.y - region.y) + this.startx -region.startx;//1000 should be big enough
		}
	}
	private ArrayList<Region> regions = new ArrayList<>();

	public FarmLand(Grid parentGrid,int x, int y)
	{
		this.parentGrid = parentGrid;
		regions.add(new Region(y,x,x));

	}

	public void add(int x,int y){
		if(contains(x,y))
			return;
		regions.add(new Region(y,x,x));
		Collections.sort(regions);
		for(int i = 0; i < regions.size() - 1;i++){

		}

	}

	public ArrayList<Region> getRegionsOnRow(int y)
	{
		ArrayList<Region> out = new ArrayList<>();
		for(Region region:regions){
			if(region.y == y)
				out.add(region);
		}
		return out;
	}
	public ArrayList<Region> getRegionsOnColumn(int x)
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
		if(getRegionsOnRow(y).size() > 0)
			return true;
		return false;
	}
	public boolean containsColumn(int x)
	{
		if(getRegionsOnColumn(x).size() > 0)
			return true;
		return false;
	}
}
