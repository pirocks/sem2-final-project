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
	private ResourceDemand resourceDemand;
	private double timeRequired;
	public ToolUnderConstruction(Type object) {
		if(object == null)
			throw new IllegalArgumentException();
		this.object = object;
		resourceDemand = object.requiredResourcesForConstruction();
		timeRequired = object.getConstructionManDays();
	}
	public boolean pay(Resource resource) {
		resource.pay(resourceDemand);
		return areWeDoneYet();
	}
	public boolean pay(double time) {
		timeRequired -= time;
		return areWeDoneYet();
	}
	public boolean areWeDoneYet() {
		if(resourceDemand == null)
			return false;// TODO: 5/30/2016 remve later
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
