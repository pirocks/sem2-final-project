package universe;

import java.util.ArrayList;

/**
 * Created by bob on 3/5/2016.
 */

/*planet contains the following:
    grid array that serves as building block of planet
    resources on each grid array
    possible hazards volcano,temperature changes,weather. hazards are local to grid array


*/
public class Planet {
    private Grid[][] grids;
    public Planet(int size)
    {
        grids = new Grid[size][size];
    }

}
