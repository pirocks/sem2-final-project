package engine.universe;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by bob on 3/5/2016.
 * Created by bob on 3/5/2016.
 */
 

public class Universe implements Serializable, CountryContainer
{
    private ArrayList<SolarSystem> solarSystems;
    private ArrayList<Country> countries;
    public Universe(int numSolarSystems,double size)//size is not related to engine.universe units
    {
        registerCountryContainer();
        solarSystems = new ArrayList<SolarSystem>();
        for(int i = 0; i < numSolarSystems;i++)
        {
            //location of solar systems
            BigDecimal largeNumber = new BigDecimal(1000000000);
            double x = ThreadLocalRandom.current().nextDouble(-size/2, size/2);
            double y = ThreadLocalRandom.current().nextDouble(-size/2, size/2);
            double z = ThreadLocalRandom.current().nextDouble(-size/2, size/2);
            solarSystems.add(new SolarSystem(new BigDecimal(x).multiply(largeNumber),new BigDecimal(y).multiply(largeNumber),new BigDecimal(z).multiply(largeNumber)));
        }
    }

	public Universe(UniverseRandomConstructionContext universeRandomConstructionContext)
	{

	}

    @Override
    public void remove(Country country,Country conqueror) {
        countries.remove(country);
    }
}
