package engine.universe;

import java.io.Serializable;
//import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by bob on 3/5/2016.
 * Created by bob on 3/5/2016.
 * todo serializable won't work on container classes need to fix
 */
 

public class Universe implements Serializable, CountryContainer
{
	public transient static Universe universe;// TODO: 5/8/2016 make this non tranient//  figure out how this will load
	public static Country playersCountry;
	private ArrayList<SolarSystem> solarSystems;
	private ArrayList<Country> countries;
    private Universe(UniverseConstructionContext u,int numSolarSystems,double size)//size is not related to engine.universe units
    {

        registerCountryContainer();
        if(u.countries == null)
	        throw new IllegalArgumentException();
	    solarSystems = new ArrayList<>();
	    countries = new ArrayList<>();
        for(int i = 0; i < numSolarSystems;i++)
        {
            //location of solar systems
            double largeNumber = 1000000000;// TODO: 5/9/2016 fix magic number
            double x = ThreadLocalRandom.current().nextDouble(-size/2, size/2);
            double y = ThreadLocalRandom.current().nextDouble(-size/2, size/2);
            double z = ThreadLocalRandom.current().nextDouble(-size/2, size/2);
            SolarSystem system = new SolarSystem(new SolarSystemConstructionContext(u));
	        system.setStar(new Star(x,y,z,system));
	        solarSystems.add(system);

        }
	    universe = this;
	    playersCountry = new Country(u);
    }
	@Deprecated public Universe(UniverseConstructionContext universeConstructionContext)
	{
		//what on earth is the point of this // TODO: 5/9/2016
		this(universeConstructionContext,universeConstructionContext.numSolarSystems,universeConstructionContext.universeRadius);
	}
    @Override
    public void remove(Country country,Country conqueror) {
        countries.remove(country);
    }

	public ArrayList<SolarSystem> getSolarSystems() {
		return solarSystems;
	}

	public ArrayList<Country> getCountries() {
		return countries;
	}

}
