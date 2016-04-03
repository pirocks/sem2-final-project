

























package universe;

public class Resource
{
	//trash.Location //when location is figured out add this.
    public static enum Type
    {
        Iron,Oil,Uranium,Helium,Food,Water
    }
    public final Type type;
    private double quantity;//don't forget to check for overflow with sun
    public static double IronValue;
    public static double OilValue;
    public static double UraniumValue;
    public static double HeliumValue;
    public static double FoodValue;
    public static double WaterValue;
    public static double getTypeValue(Type type)
    {
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
	public Resource(Type type,double quantity)
	{
		this.type = type;
		this.quantity = quantity;
	}
	public Resource(Type type)
	{
		this(type,0.0);
	}
	public void add(Resource r)
	{
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
	public Resource split(double amount)
	{
		quantity -= amount;
		return new Resource(type,amount);
	}
	public void pay(ResourceDemand r)
	{
		assert(this.type == r.type);
		quantity -= r.quantity;
		r.quantity = 0;
	}
	
}