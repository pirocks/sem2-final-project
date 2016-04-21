package engine.tools;

import engine.universe.Resource;
import engine.universe.ResourceDemand;

import java.io.Serializable;

/**
 * Created by bob on 4/6/2016.
 *
 */
public class ToolUnderConstruction <Type extends Tool> implements Serializable
{
	private Type object;
	private ResourceDemand resourceDemand = object.requiredResourcesForConstruction();
	private long timeRequired = object.constructionManHours();
	public ToolUnderConstruction(Type object)
	{
		this.object = object;
	}
	public boolean pay(Resource resource)
	{
		resource.pay(resourceDemand);
		return areWeDoneYet();
	}
	public boolean pay(long time)
	{
		timeRequired -= time;
		return areWeDoneYet();
	}
	private boolean areWeDoneYet()
	{
		return timeRequired < 0 || resourceDemand.quantity == 0;
	}
	public Type getFinishedTool()
	{
		if(areWeDoneYet())
			return object;
		return null;//// TODO: 4/8/2016 actually this should work
	}
}
