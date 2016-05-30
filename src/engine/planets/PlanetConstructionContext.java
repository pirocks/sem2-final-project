package engine.planets;

import engine.universe.Country;
import engine.universe.SolarSystemConstructionContext;
import engine.universe.Star;
import engine.universe.utils;

import java.util.ArrayList;

/**
 * Created by bob on 4/10/2016.
 *
 */
public class PlanetConstructionContext {
    double radiusFromSolarSystem;
    Star               star;
    ArrayList<Country> countries;
    int                gridNum;
	int                numHazards;
    //	public static enum ResourceAbundance
    //	{
    //		veryLow,low, mediumLow,medium, mediumHigh,high, veryHigh
    //	}
    double             IronAbundance;    //0 is none while 1 is all grids have it
    double             OilAbundance;
    double             UraniumAbundance;
    double             HeliumAbundance;
    double             FoodAbundance;
    double             WaterAbundance;
	double             cityDensity;
	double industryProb;

	public PlanetConstructionContext(
			double radius,
			Star star,
			ArrayList<Country> countries,
			int gridNum,
			double percentWater,
			int numHazards,
			double IronAbundance,
			double OilAbundance,
			double UraniumAbundance,
			double HeliumAbundance,
			double FoodAbundance,
			double WaterAbundance,
			double cityDensity,
			double industryProb)
	{
		if(countries == null)
			throw new IllegalArgumentException();
		this.radiusFromSolarSystem = radius;
		this.star = star;
		this.countries = countries;
		this.gridNum = gridNum;
		this.numHazards = numHazards;
		this.IronAbundance = IronAbundance;
		this.OilAbundance = OilAbundance;
		this.UraniumAbundance = UraniumAbundance;
		this.HeliumAbundance = HeliumAbundance;
		this.FoodAbundance = FoodAbundance;
		this.WaterAbundance = WaterAbundance;

		this.cityDensity = cityDensity;
		this.industryProb = industryProb;
	}


    private void copyInto(PlanetConstructionContext p) {
	    if(p.countries == null)
		    throw new IllegalArgumentException();
//	    if(p.star == null)
//		    throw new IllegalArgumentException();
	    this.radiusFromSolarSystem = p.radiusFromSolarSystem + utils.getRandomDouble(100000,1000000);// TODO: 5/9/2016 make sure these nums are reasonable//they are because I said so.
	    this.star = p.star;
	    this.countries = p.countries;
	    this.gridNum = p.gridNum;
	    this.numHazards = p.numHazards;
	    this.IronAbundance = p.IronAbundance;
	    this.OilAbundance = p.OilAbundance;
	    this.UraniumAbundance = p.UraniumAbundance;
	    this.HeliumAbundance = p.HeliumAbundance;
	    this.FoodAbundance = p.FoodAbundance;
	    this.WaterAbundance = p.WaterAbundance;

	    this.cityDensity = p.cityDensity;
	    this.industryProb = p.industryProb;
    }

    public PlanetConstructionContext(SolarSystemConstructionContext s) {
        int num = utils.getRandomInt(0, 3);
        switch (num) {
            case 0:
                copyInto(s.context1);
                break;
            case 1:
                copyInto(s.context2);
                break;
            case 2:
                copyInto(s.context3);
                break;
            case 3:
                copyInto(s.context2);
                break;
            default:
                copyInto(s.context3);
                break;
        }
    }

}
