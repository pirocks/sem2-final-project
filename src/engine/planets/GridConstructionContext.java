package engine.planets;

import engine.planets.hazards.NaturalHazard;
import engine.planets.hazards.Volcano;
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
//		surroundingTerrains.add(grids[y - 0][x - 0].getTerrainType());
		try {
			surroundingTerrains.add(grids[y - 0][x - 1].getTerrainType());
		} catch (IndexOutOfBoundsException e) {
			//do nothing
		}
		try {
			surroundingTerrains.add(grids[y - 0][x - 2].getTerrainType());
		} catch (IndexOutOfBoundsException e) {

		}
		try {
			surroundingTerrains.add(grids[y - 1][x - 0].getTerrainType());
		} catch (IndexOutOfBoundsException e) {

		}
		try {
			surroundingTerrains.add(grids[y - 1][x - 1].getTerrainType());
		} catch (IndexOutOfBoundsException e) {

		}
		try {
			surroundingTerrains.add(grids[y - 1][x - 2].getTerrainType());
		} catch (IndexOutOfBoundsException e) {

		}
		try {
			surroundingTerrains.add(grids[y - 2][x - 0].getTerrainType());
		} catch (IndexOutOfBoundsException e) {

		}
		try {
			surroundingTerrains.add(grids[y - 2][x - 1].getTerrainType());
		} catch (IndexOutOfBoundsException  e) {

		}
		try {
			surroundingTerrains.add(grids[y - 2][x - 2].getTerrainType());
		} catch (IndexOutOfBoundsException e) {

		}
	}
	public TerrainType getSuitableTerrainType()
	{
		// TODO: 5/10/2016
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
		else if(LandCount - 4 < surroundingTerrains.size())
			return Land;
		else if(WastelandCount  > LandCount)
			return Wasteland;
		int rand = (int) (Math.random()*(surroundingTerrains.size() + 1));
		// TODO: 5/10/2016 the below can be done better
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
