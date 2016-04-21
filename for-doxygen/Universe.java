package engine.universe;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by bob on 3/5/2016.
 * Created by bob on 3/5/2016.
 * todo serialazable won't work on container classes need to fix
 */
 

public class Universe implements Serializable, CountryContainer
{
    private ArrayList<SolarSystem> solarSystems;
    private ArrayList<Country> countries;
    public Universe(int numSolarSystems,double size)//size is not related to engine.universe units
    {
        registerCountryContainer();
        solarSystems = new ArrayList<>();
	    countries = new ArrayList<>();
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
		final int numCountries = universeRandomConstructionContext.numCountries;
		final int numSolarSystems = universeRandomConstructionContext.numSolarSystems;
		final double universeRadius = universeRandomConstructionContext.universeRadius;
		final int numMinPlanets = universeRandomConstructionContext.numMinPlanets;
		final int numMaxPlanrts = universeRandomConstructionContext.numMaxPlanets;
		registerCountryContainer();
		ArrayList<UnConstructedSolarSystem> UnConstructedSolarSystems = new ArrayList<>();
		for(int i = 0; i < numSolarSystems;i++)
		{
			//location of solar systems
			BigDecimal largeNumber = new BigDecimal(1000000000);
			double x = utils.getRandomDouble(-universeRadius, universeRadius);
			double y = utils.getRandomDouble(-universeRadius, universeRadius);
			double z = utils.getRandomDouble(-universeRadius, universeRadius);
			UnConstructedSolarSystems.add(new UnConstructedSolarSystem(new BigDecimal(x).multiply(largeNumber),
					new BigDecimal(y).multiply(largeNumber),
					new BigDecimal(z).multiply(largeNumber)));
		}
		ArrayList<SolarSystemRandomConstructionContext> constructionContexts = new ArrayList<>();
		ArrayList<ArrayList<Country>> countries  = new ArrayList<>();
		for(int  i = 0; i < universeRandomConstructionContext.numCountries;i++)
		{
			countries.set(i,new ArrayList<>());// TODO: 4/11/2016 figure out how o get apprpriate num of countries//add them safter the fact  or make a condition that there must be more solars than countries
		}

		int i = 0;
		for(UnConstructedSolarSystem unConstructed:UnConstructedSolarSystems){
			constructionContexts.add(new SolarSystemRandomConstructionContext(
					unConstructed,universeRandomConstructionContext.numMaxPlanets,
					universeRandomConstructionContext.numMinPlanets,countries.get(i)));
			i++;
		}
	}

    @Override
    public void remove(Country country,Country conqueror) {
        countries.remove(country);
    }
}
