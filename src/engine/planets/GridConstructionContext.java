package engine.planets;

import engine.universe.Country;
import engine.universe.Resource;

import java.util.ArrayList;

import static engine.planets.TerrainType.*;

/**
 * Created by bob on 4/11/2016.
 *
 */
public class GridConstructionContext
{
	int x,y;
	double hazardAbundance;
//	ArrayList<NaturalHazard> hazards; handalleed by grid becuase parent grid needed in constructor
	ArrayList<NaturalResource> naturalResources;
	private ArrayList<TerrainType> surroundingTerrains;// 4/11/2016 shoul  have an intial method which determines all terrain types before actually constructing grids would als fix above issue with hazards and resources by predefining which resources hazards and terrains to have
	double citiesPerGrid;
	Country country;
	public double industryProb;

	public GridConstructionContext(PlanetConstructionContext planetConstructionContext,
	                               Grid[][] grids, int y, int x,
	                               double citiesPerGrid, Country country, double industryProb)
	{
		this.y = y;
		this.x = x;
		this.citiesPerGrid = citiesPerGrid;
		this.country = country;
		this.industryProb = industryProb;
//		hazards = new ArrayList<>();
		int numGrids = planetConstructionContext.gridNum* planetConstructionContext.gridNum;
		hazardAbundance = planetConstructionContext.numHazards/numGrids;
		naturalResources = new ArrayList<>();
		double ironProb = Math.random();
		if(ironProb < planetConstructionContext.IronAbundance)
			naturalResources.add(new NaturalResource(Resource.Type.Iron,10000,0,10000));
		double OilProb = Math.random();
		if(OilProb < planetConstructionContext.OilAbundance)
			naturalResources.add(new NaturalResource(Resource.Type.Oil,10000,0,10000));
		double UraniumProb = Math.random();
		if(UraniumProb < planetConstructionContext.UraniumAbundance)
			naturalResources.add(new NaturalResource(Resource.Type.Uranium,1000,0,1000));
		double HeliumProb = Math.random();
		if(HeliumProb < planetConstructionContext.HeliumAbundance)
			naturalResources.add(new NaturalResource(Resource.Type.Helium,1000,0,1000));
		double FoodProb = Math.random();
		if(FoodProb < planetConstructionContext.FoodAbundance)
			naturalResources.add(new NaturalResource(Resource.Type.Food,10000,1000,10000));
		double WaterProb = Math.random();
		if(WaterProb < planetConstructionContext.WaterAbundance)
			naturalResources.add(new NaturalResource(Resource.Type.Water,10000,1000,10000));
		surroundingTerrains = new ArrayList<>();
		try
		{
			surroundingTerrains.add(grids[y - 0][x - 1].getTerrainType());
		} catch (IndexOutOfBoundsException e) {}
		try
		{
			surroundingTerrains.add(grids[y - 0][x - 2].getTerrainType());
		} catch (IndexOutOfBoundsException ignored) {}
		try
		{
			surroundingTerrains.add(grids[y - 1][x - 0].getTerrainType());
		} catch (IndexOutOfBoundsException ignored) {}
		try
		{
			surroundingTerrains.add(grids[y - 1][x - 1].getTerrainType());
		} catch (IndexOutOfBoundsException ignored) {}
		try
		{
			surroundingTerrains.add(grids[y - 1][x - 2].getTerrainType());
		} catch (IndexOutOfBoundsException ignored) {}
		try
		{
			surroundingTerrains.add(grids[y - 2][x - 0].getTerrainType());
		} catch (IndexOutOfBoundsException ignored) {}
		try
		{
			surroundingTerrains.add(grids[y - 2][x - 1].getTerrainType());
		} catch (IndexOutOfBoundsException ignored) {}
		try
		{
			surroundingTerrains.add(grids[y - 2][x - 2].getTerrainType());
		} catch (IndexOutOfBoundsException ignored) {}
	}
	public TerrainType getSuitableTerrainType()
	{
		int LandCount = 0;
		int SeaCount = 0;
		int CoastCount = 0;
		int MountainsCount = 0;
		int HillsCount = 0;
		int WastelandCount = 0;
		for(TerrainType type:surroundingTerrains)
		{
			switch(type)
			{
				case Land:
					LandCount++;
					break;
				case Sea:
					SeaCount++;
					break;
				case Coast:
					CoastCount++;
					break;
				case Mountains:
					MountainsCount++;
					break;
				case Hills:
					HillsCount++;
					break;
				case Wasteland:
					WastelandCount++;
					break;
			}
		}
		if(SeaCount + CoastCount - 2 == surroundingTerrains.size())
			return Sea;
		else if(MountainsCount + HillsCount - 1  == surroundingTerrains.size())
			if(MountainsCount > HillsCount)
				return Mountains;
			else
				return Hills;
		if(SeaCount == 1 || SeaCount == 2 || SeaCount == 3)
			return Sea;
		if(LandCount == surroundingTerrains.size())
			if(Math.random() < 0.5)
				return Sea;
			else
				return Land;
		else if (LandCount >  WastelandCount)
			return Land;
		else if(LandCount == WastelandCount) {
			double rand = Math.random();
			if (rand < 0.2)
				return Wasteland;
			else if (rand < 0.7)
				return Land;
			else
				return Hills;
		}
		else if(WastelandCount  > LandCount)
			return Wasteland;
		int rand = (int) (Math.random()*(surroundingTerrains.size() + 1));
		switch(rand)
		{
			case 0:
				return Land;
			case 2:
				return Sea;
			case 3:
				return Coast;
			case 4:
				return Mountains;
			case 5:
				return Hills;
			case 6:
				return Wasteland;
			default:
				return Land;
		}
	}

}
