package universe;
import unibverse.*;

public class ResourceDemand
{
	public Resource.Type type;
	public double quantity;
	public ResourceDemand(Resource.Type type,double quantity)
	{
		this.type = type;
		this.quantity = quantity;
	}
}