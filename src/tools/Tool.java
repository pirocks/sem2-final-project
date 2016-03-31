package tools;


public class Tool
{
	static enum Type
	{
		
	}
	public final Type type;
	public abstract boolean vehicleQ();
	public abstract boolean weaponQ();
	public abstract boolean ResourceDemand requiredResources();
	public abstract boolean double constructionCost();
}