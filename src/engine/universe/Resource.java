package engine.universe;

import engine.tools.vehicles.Weighable;

import java.io.Serializable;
import java.util.ArrayList;

public class Resource implements Serializable,Weighable
{
	public enum Type
    {
        Iron,Oil,Uranium,Helium,Food,Water,Wood
    }
	public ArrayList<Type> type;
	private ArrayList<Double> quantity;//don't forget to check for overflow with sun
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
	public Resource(ArrayList<Type> type, ArrayList<Double> quantity) {
		this.type = type;
		this.quantity = quantity;
	}
	public Resource(ArrayList<Type> type)
	{
		this(type,);
	}
	public Resource(Type type,double quantity)
	{
		this.type = new ArrayList<>();
		this.type.add(type);
		this.quantity = new ArrayList<>();
		this.quantity.add(quantity);
	}
	public void add(Resource r) {
		assert(r.type == this.type);
		quantity += r.getQuantity();
		r.clear();
	}
	public double getQuantity()
	{
		return quantity;
	}
	public void clear()
	{
		quantity = 0.0;
	}
	public Resource split(double amount) {
		quantity -= amount;
		return new Resource(type,amount);
	}
	public void pay(ResourceDemand r) {
		assert(this.type == r.type);
		quantity -= r.quantity;
		r.quantity = 0;
	}
	@Override
	public double getWeight() {
		return getWeightType(type)*quantity;
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

}