package engine.universe;

import engine.tools.vehicles.Weighable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Resource implements Serializable,Weighable
{
	public enum Type
    {
        Iron,Oil,Uranium,Helium,Food,Water,Wood
    }

	private Map<Type,Double> values;

	public static double IronValue;
	public static double OilValue;
	public static double UraniumValue;
	public static double HeliumValue;
	public static double FoodValue;
	public static double WoodValue;
	public static double WaterValue;
	public static double IronWeight;
	public static double OilWeight;
	public static double UraniumWeight;
	public static double HeliumWeight;
	public static double FoodWeight;
	public static double WaterWeight;
	public static double WoodWeight;
	public static double getTypeValue(Type type) {
    	switch(type)
    	{
	        case Iron:
	        	return IronValue;
	        case Oil:
	        	return OilValue;
	        case Uranium:
	        	return UraniumValue;
	        case Helium:
	        	return HeliumValue;
	        case Food:
	        	return FoodValue;
	        case Water:
	        	return WaterValue;
		    case Wood:
			    return WoodValue;
		    default:
	        	assert(false);
	        	throw new IllegalStateException();
    	}
    }
	public Resource(ArrayList<Type> types, ArrayList<Double> quantities) {
		values = new HashMap<>();
		values.put(Type.Iron, (double) 0);
		values.put(Type.Oil, (double) 0);
		values.put(Type.Uranium, (double) 0);
		values.put(Type.Helium, (double) 0);
		values.put(Type.Food, (double) 0);
		values.put(Type.Wood, (double) 0);
		values.put(Type.Water, (double) 0);
		for (int i = 0; i < types.size(); i++) {
			Type type = types.get(i);
			double val = quantities.get(i);
			values.put(type,val);
		}
	}
	public Resource(Type type)
	{
		this(new ArrayList<Type>(){{add(type);}},new ArrayList<Double>(){{add(Double.NaN);}});
	}
	public Resource(Type type,double quantity)
	{
		this(new ArrayList<Type>(){{add(type);}},new ArrayList<Double>(){{add(quantity);}});
	}
	public void add(Resource r) {
		sanityCheck();
		for (Type type : r.getValues().keySet()) {
			values.put(type,values.get(type) + r.getValues().get(type));
		}
		sanityCheck();
	}
	public double getQuantity(Type type)
	{
		sanityCheck();
		return values.get(type);
	}
	private void subtract(Resource r) {
		for (Type type : r.getValues().keySet()) {
			values.put(type,values.get(type) - r.getValues().get(type));
		}
		sanityCheck();
	}
	public void pay(ResourceDemand r) {
		subtract(r.getResource());
	}
	@Override
	public double getWeight() {
		double weight = 0;
		for (Type type : values.keySet()) {
			weight += getWeightType(type)* values.get(type);
		}
		return weight;
	}
	private static double getWeightType(Type type)
	{
		switch (type)
		{
			case Iron:
				return IronWeight;
			case Oil:
				return OilWeight;
			case Uranium:
				return UraniumWeight;
			case Helium:
				return HeliumWeight;
			case Food:
				return FoodWeight;
			case Water:
				return WaterWeight;
			case Wood:
				return WoodWeight;
			default:
				throw new IllegalStateException();
		}
	}
	private void sanityCheck()
	{
		for (Double quantity : values.values()) {
			assert (quantity > 0 || quantity == Double.NaN);
			if(quantity < 0 || quantity != Double.NaN)
				throw  new IllegalStateException();
		}

	}
	public Map<Type, Double> getValues() {
		return values;
	}

}