package engine.universe;

import java.io.Serializable;

public class ResourceDemand implements Serializable
{
	private Resource resource;
	public ResourceDemand(Resource resource)
	{
		this.resource = resource;
	}

	public Resource getResource() {
		return resource;
	}

	public ResourceDemand(Resource.Type[] types,double startHealth,double resistance,double maxWeight,double maxPassengers)
	{
		// TODO: 5/22/2016
	}

	public boolean fullFilledQ()
	{
		for (Double quantity : resource.getValues().values()) {
			if(quantity != 0)
				return false;
		}
		return true;

	}

	public double getWeight() {
		return resource.getWeight();
	}
}