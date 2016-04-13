package engine.planets;

/**
 * Created by bob on 3/5/2016.
 *
 */

import engine.universe.Country;

import java.io.Serializable;
import java.util.ArrayList;

 
public class Continent implements Serializable
{
	// TODO: 4/9/2016 constructor
	private ArrayList<Grid> grids;
    private String name;
    public ArrayList<Country> containedCountries()
    {
        ArrayList<Country> out = new ArrayList<Country>();
        for(Grid grid:grids)
        {
            if(!out.contains(grid))
               out.add(grid.getParentCountry());
        }
        return out;
    }
}
