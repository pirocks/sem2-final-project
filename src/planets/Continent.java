package planets;

/**
 * Created by bob on 3/5/2016.
 */

import java.util.ArrayList;

 
public class Continent
{
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
