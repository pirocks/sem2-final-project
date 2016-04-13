package engine.buildings;

import engine.buildings.Building;
import engine.buildings.workplaces.Workplace;
import engine.cities.CityBlock;
import engine.people.cityworkers.CityWorker;
import engine.universe.MoneySource;
import engine.universe.ResourceDemand;

import java.io.Serializable;
import java.util.ArrayList;

class UnderConstruction<Type extends Building> implements Serializable
{
	private Type type;
	private double progress = 0.0;
	public UnderConstruction()
	{
		//make call to super but then change resistance etc.
	}
}