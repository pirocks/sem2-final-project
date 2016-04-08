package engine.universe;

import engine.tools.vehicles.Weighable;

public class Resource implements Weighable
{
	public static enum Type
    {
        Iron,Oil,Uranium,Helium,Food,Water;
    }
	public final Type type;
	private double quantity;//don't forget to check for overflow with sun
	public static double IronValue;
	public static double OilValue;
	public static double UraniumValue;
	public static double HeliumValue;
	public static double FoodValue;
	public static double WaterValue;
	public static double IronWeight;
	public static double OilWeight;
	public static double UraniumWeight;
	public static double HeliumWeight;
	public static double FoodWeight;
	public static double WaterWeight;
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
	        default:
	        	assert(false);
	        	throw new IllegalStateException();
    	}
    }
	public Resource(Type type,double quantity) {
		this.type = type;
		this.quantity = quantity;
	}
	public Resource(Type type)
	{
		this(type,0.0);
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
			default:
				throw new IllegalStateException();
		}
	}

}