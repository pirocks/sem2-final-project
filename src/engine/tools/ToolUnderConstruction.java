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
	private double timeRequired = object.getConstructionManDays();
	public ToolUnderConstruction(Type object) {
		this.object = object;
	}
	public boolean pay(Resource resource) {
		resource.pay(resourceDemand);
		return areWeDoneYet();
	}
	public boolean pay(double time) {
		timeRequired -= time;
		return areWeDoneYet();
	}
	public boolean areWeDoneYet()
	{
		return timeRequired < 0 && resourceDemand.fullFilledQ();
	}
	public Type getFinishedTool() {
		if(areWeDoneYet())
			return object;
		return null;
	}
	public ResourceDemand getResourcesRequired()
	{
		return resourceDemand;
	}
	public double getTimeRequired() {
		return timeRequired;
	}
	public Type getTool(){
		return object;
	}
	public String getName() {
		return object.getClass().getName();
	}
}
