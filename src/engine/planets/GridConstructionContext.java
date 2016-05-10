package engine.planets;

import engine.planets.hazards.NaturalHazard;
import engine.planets.hazards.Volcano;
import engine.universe.Resource;

import java.util.ArrayList;

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
	ArrayList<TerrainType> surroundingTerrains;// TODO: 4/11/2016 shoul  have an intial method which determines all terrain types before actually constructing grids would als fix above issue with hazards and resources by predefining which resources hazards and terrains to have

	public GridConstructionContext(PlanetConstructionContext planetConstructionContext,Grid[][] grids,int y, int x)
	{
//		hazards = new ArrayList<>();
		int numGrids = planetConstructionContext.gridNum* planetConstructionContext.gridNum;
		hazardAbundance = planetConstructionContext.numHazards/numGrids;
		naturalResources = new ArrayList<>();
		double ironProb = Math.random();
		if(ironProb < planetConstructionContext.IronAbundance)
			naturalResources.add(new NaturalResource(Resource.Type.Iron,100,0,100));// TODO: 5/10/2016 magic constants and this number probly needs to be bigger
		double OilProb = Math.random();
		if(OilProb < planetConstructionContext.OilAbundance)
			naturalResources.add(new NaturalResource(Resource.Type.Oil,100,0,100));
		double UraniumProb = Math.random();
		if(UraniumProb < planetConstructionContext.UraniumAbundance)
			naturalResources.add(new NaturalResource(Resource.Type.Uranium,100,0,100));
		double HeliumProb = Math.random();
		if(HeliumProb < planetConstructionContext.HeliumAbundance)
			naturalResources.add(new NaturalResource(Resource.Type.Helium,100,0,100));
		double FoodProb = Math.random();
		if(FoodProb < planetConstructionContext.FoodAbundance)
			naturalResources.add(new NaturalResource(Resource.Type.Food,100,0,100));
		double WaterProb = Math.random();
		if(WaterProb < planetConstructionContext.WaterAbundance)
			naturalResources.add(new NaturalResource(Resource.Type.Water,100,0,100));
		surroundingTerrains = new ArrayList<>();
		surroundingTerrains.add(grids[y - 0][x - 0].getTerrainType());
		surroundingTerrains.add(grids[y - 0][x - 1].getTerrainType());
		surroundingTerrains.add(grids[y - 0][x - 2].getTerrainType());
		surroundingTerrains.add(grids[y - 1][x - 0].getTerrainType());
		surroundingTerrains.add(grids[y - 1][x - 1].getTerrainType());
		surroundingTerrains.add(grids[y - 1][x - 2].getTerrainType());
		surroundingTerrains.add(grids[y - 2][x - 0].getTerrainType());
		surroundingTerrains.add(grids[y - 2][x - 1].getTerrainType());
		surroundingTerrains.add(grids[y - 2][x - 2].getTerrainType());
	}
	public TerrainType getSuitableTerrainType()
	{
		// TODO: 5/10/2016
	}

}
