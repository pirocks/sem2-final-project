package universe;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by bob on 3/5/2016.
 * Created by bob on 3/5/2016.
 */
public class Universe extends UniqueId
{
    private ArrayList<SolarSystem> solarSystems;

    public Universe(int numSolarSystems,double size)
    {
        solarSystems = new ArrayList<SolarSystem>();
        for(int i = 0; i < numSolarSystems;i++)
        {
            //location of solar systems
            final double centerX = 0;
            final double centerY = 0;
            double x = ThreadLocalRandom.current().nextDouble(-size/2, size/2);
            double y = ThreadLocalRandom.current().nextDouble(-size/2, size/2);
            double XdistanceSquared = (centerX - x)*(centerX - x);
            double YdistanceSquared = (centerY - y)*(centerY - y);
            solarSystems.add(new SolarSystem(Math.sqrt(XdistanceSquared + YdistanceSquared)));
        }
    }
}
