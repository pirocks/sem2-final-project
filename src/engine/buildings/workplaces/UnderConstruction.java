package engine.buildings.workplaces;

import engine.cities.CityBlock;
import engine.people.cityworkers.CityWorker;
import engine.universe.MoneySource;
import engine.universe.ResourceDemand;

import java.util.ArrayList;

@Deprecated class UnderConstruction extends Workplace
{
	private Type type;
	private double progress = 0.0;
	//how are rresources being managed???
	public UnderConstruction(CityBlock block, ArrayList<CityWorker> builders, boolean housingQ, MoneySource owner)
	{
		super(builders,block,owner);
		//make call to super but then change resistance etc.
	}

	@Override
	public ResourceDemand getResourceCost() {
		return null;// TODO: 4/9/2016
	}

	@Override
	public double getCost() {
		return 0;// TODO: 4/9/2016
	}
}