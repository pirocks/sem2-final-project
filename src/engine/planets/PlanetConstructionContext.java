package engine.planets;

import engine.universe.Country;
import engine.universe.SolarSystemConstructionContext;
import engine.universe.Star;
import engine.universe.*;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by bob on 4/10/2016.
 *
 */
public class PlanetConstructionContext {
    double             radius;
    Star               star;
    ArrayList<Country> countries;// TODO: 5/10/2016 planets  don't have cpountries/citys randomly generrated yet
    int                gridNum;
    double             percentWater;// TODO: 5/10/2016 make sure this is actually used or not
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

	public PlanetConstructionContext(
			double             radius,
			Star               star,
			ArrayList<Country> countries,
			int                gridNum,
			double             percentWater,
			int                numHazards,
			double             IronAbundance,
			double             OilAbundance,
			double             UraniumAbundance,
			double             HeliumAbundance,
			double             FoodAbundance,
			double             WaterAbundance
	)
	{
		this.radius = radius;
		this.star = star;
		this.countries = countries;
		this.gridNum = gridNum;
		this.percentWater = percentWater;
		this.numHazards = numHazards;
		this.IronAbundance = IronAbundance;
		this.OilAbundance = OilAbundance;
		this.UraniumAbundance = UraniumAbundance;
		this.HeliumAbundance = HeliumAbundance;
		this.FoodAbundance = FoodAbundance;
		this.WaterAbundance = WaterAbundance;

	}


    private void copyInto(PlanetConstructionContext p) {
        this.radius = p.radius + utils.getRandomDouble(100000,1000000);// TODO: 5/9/2016 make sure these nums are reasonable
        this.star = p.star;
        this.countries = p.countries;
        this.gridNum = p.gridNum;
        this.percentWater = p.percentWater;
        this.numHazards = p.numHazards;
        this.IronAbundance = p.IronAbundance;
        this.OilAbundance = p.OilAbundance;
        this.UraniumAbundance = p.UraniumAbundance;
        this.HeliumAbundance = p.HeliumAbundance;
        this.FoodAbundance = p.FoodAbundance;
        this.WaterAbundance = p.WaterAbundance;
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
