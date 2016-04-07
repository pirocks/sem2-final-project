package tools;

import universe.ResourceDemand;

public abstract class Tool
{

	protected Tool()
	{
		//TODO think of sme code to put here
		//what about construction costs
		//constructor from a another class
	}
//	public final Type type;
	public abstract boolean vehicleQ();
	public abstract boolean weaponQ();
	public abstract ResourceDemand requiredResourcesForConstruction();
	public abstract long constructionManHours();//doesn't need o be abstract
}