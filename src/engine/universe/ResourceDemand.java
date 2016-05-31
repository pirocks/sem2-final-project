package engine.universe;

import java.io.Serializable;

public class ResourceDemand implements Serializable
{
	private Resource resource;
	public ResourceDemand(Resource resource)
	{
		this.resource = resource;
	}

	public ResourceDemand() {
		resource = new Resource(Resource.Type.Food);//doesn;t matter as long as its zero
	}

	public ResourceDemand(Resource.Type[] types, double startHealthInitial, double resistanceInitial, double damageInitial, double rangeInitial, double accuracyInitial) {
		// TODO: 5/30/2016
	}

	public ResourceDemand(Resource.Type[] types, double healthInitial, double resistanceInitial, int maximumOccupancyInitial) {
		// TODO: 5/30/2016
	}

	public Resource getResource() {
		return resource;
	}

	public ResourceDemand(Resource.Type[] types,double startHealth,double resistance,double maxWeight,double maxPassengers) {
		// TODO: 5/22/2016
	}

	public boolean fullFilledQ()
	{
		try {
			for (Double quantity : resource.getValues().values()) {
				if (quantity != 0)
					return false;
			}
		}catch (NullPointerException ignored){
			return false;
		}
		return true;

	}

	public double getWeight() {
		if(resource == null)
			return 0;// TODO: 5/30/2016 remove later
		return resource.getWeight();
	}

	public void pay(Resource resource) {
		resource.pay(this);
	}
}