package engine.universe;

import java.io.Serializable;

public class ResourceDemand implements Serializable
{
	public Resource.Type type;
	public double quantity;
	public ResourceDemand(Resource.Type type,double quantity)
	{
		this.type = type;
		this.quantity = quantity;
	}
}