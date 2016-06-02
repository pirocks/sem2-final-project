package engine.universe;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class ResourceDemand implements Serializable
{
	private Resource resource;
	public ResourceDemand(Resource resource)
	{
		this.resource = resource;
	}
	public ResourceDemand() {
		resource = new Resource(Resource.Type.Food);//doesn't matter as long as its zero
	}
	public ResourceDemand(Resource.Type[] types, double startHealthInitial, double resistanceInitial, double damageInitial, double rangeInitial, double accuracyInitial) {
		//weapons

	}
	public ResourceDemand(Resource.Type[] types, double healthInitial, double resistanceInitial, int maximumOccupancyInitial) {
		//buildings


	}
	public ResourceDemand(Resource.Type[] types,double startHealth,double resistance,double maxWeight,double maxPassengers) {
		//vehicles
		double uraniumQuantity = 0;
		double waterQuantity = 0;
		double woodQuantity = 0;
		double ironQuantity = Math.sqrt(startHealth)*10 + resistance;
		double oilQuantity = maxPassengers + Math.sqrt(maxWeight);
		double siliconQuantity = Math.log10(ironQuantity + oilQuantity);
		if(new ArrayList<Resource.Type>(Arrays.asList(types)).contains(Resource.Type.Uranium)){
			uraniumQuantity += siliconQuantity;
		}
		if(new ArrayList<Resource.Type>(Arrays.asList(types)).contains(Resource.Type.Wood)){
			woodQuantity += Math.sqrt(siliconQuantity + oilQuantity);
		}
		if(new ArrayList<Resource.Type>(Arrays.asList(types)).contains(Resource.Type.Wood)) {
			waterQuantity += Math.sqrt(ironQuantity);
		}
		resource = new Resource(new Resource.Type[]{Resource.Type.Uranium,Resource.Type.Water,Resource.Type.Wood,Resource.Type.Iron,Resource.Type.Oil,Resource.Type.Silicon},new Double[]{uraniumQuantity, waterQuantity, woodQuantity,ironQuantity,oilQuantity,siliconQuantity});
	}
	public boolean fullFilledQ() {
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
	public void mult(int num) {
		resource.mult(num);
	}
	public Resource getResource() {
		return resource;
	}
}