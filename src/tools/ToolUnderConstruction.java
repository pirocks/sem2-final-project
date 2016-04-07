package tools;

import universe.Resource;
import universe.ResourceDemand;

/**
 * Created by bob on 4/6/2016.
 *
 */
public class ToolUnderConstruction <Type extends Tool>
{
	private Type type;
	private ResourceDemand resourceDemand = type.requiredResourcesForConstruction();
	private long timeRequired = type.constructionManHours();
	public boolean pay(Resource resource)
	{
		resource.pay(resourceDemand);
		return areWeDoneYet();
	}
	public boolean pay(long time)
	{
		timeRequired -= time;
		return areWeDoneYet();
		//todo what to do when consytruction complete//return a boolean?
	}
	private boolean areWeDoneYet()
	{
		if(timeRequired < 0 || resourceDemand.quantity == 0)
			return true;
		return false;
	}
}
