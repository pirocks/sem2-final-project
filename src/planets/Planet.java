package planets;

/**
 * Created by bob on 3/5/2016.
 */


import universe.UniqueId;
import universe.SolarSystem;
import java.util.ArrayList;

/*planet contains the following:
    grid array that serves as building block of planet
    resources on each grid array
    possible hazards volcano,temperature changes,weather. hazards are local to grid array


*/
public class Planet extends UniqueId
{
    private SolarSystem parentSolarSystem;
    private double radius;//distance in universe units
    Grid[][] grids;
    public Planet(int size)
    {
        super();
        grids = new Grid[size][size * 2];
    }
}
