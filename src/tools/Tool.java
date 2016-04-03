package tools;

import universe.ResourceDemand;

public abstract class Tool
{

	protected Tool(Type type) {
		this.type = type;
	}

	public static enum Type
	{
		Vehicle,weapon
	}
	public final Type type;
	public abstract boolean vehicleQ();
	public abstract boolean weaponQ();
	public abstract ResourceDemand requiredResourcesForConstruction();
	public abstract long constructionManHours();//doesn't need o be abstract
}