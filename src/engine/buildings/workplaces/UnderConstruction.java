package engine.buildings.workplaces;

import engine.cities.CityBlock;
import engine.people.cityworkers.CityWorker;
import engine.universe.MoneySource;

import java.util.ArrayList;

public class UnderConstruction extends Workplace
{
	private Type type;
	private double progress = 0.0;
	//how are rresources being managed???
	public UnderConstruction(CityBlock block, ArrayList<CityWorker> builders, boolean housingQ, MoneySource owner)
	{
		super(builders,block,owner);
		//make call to super but then change resistance etc.
	}
}