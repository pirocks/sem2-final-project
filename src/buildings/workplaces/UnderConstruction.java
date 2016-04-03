package buildings.workplaces;

import buildings.Workplace;
import cities.CityBlock;
import people.CityWorker;
import universe.MoneySource;

import java.util.ArrayList;

public class UnderConstruction extends Workplace
{
	private Type type;
	private double progress = 0.0;
	//how are rresources being managed???
	public UnderConstruction(Type type, CityBlock block, ArrayList<CityWorker> builders, boolean housingQ, MoneySource owner)
	{
		super(type, builders,block,owner);
		//make call to super but then change resistance etc.
	}
}