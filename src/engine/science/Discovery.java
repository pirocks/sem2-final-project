package engine.science;

import engine.buildings.workplaces.ResearchArea;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Discovery implements Serializable
{
	private double percentComplete = 0.0; //0 to 1
	private ArrayList<Discovery> required;
	private ArrayList<ResearchArea> workingOn;

	protected Discovery(ArrayList<Discovery> required) {
		this.required = required;
	}

	public abstract void postDiscovery();
	public boolean canBeResearched()
	{
		for(Discovery discovery:required)
			if(!discovery.discoveredQ())
				return false;
		return true;
	}
	public void makeProgress(double progress)
	{
		assert(percentComplete < 1.0);
		assert(canBeResearched());
		percentComplete += progress;
		if(percentComplete >= 1.0)
			postDiscovery();
	}
	public boolean discoveredQ()
	{
		return percentComplete > 1.0;
	}
	public void registerResearchArea(ResearchArea researchArea)
	{
		workingOn.add(researchArea);
	}
	public void deregisterResearchArea(ResearchArea researchArea) {
		workingOn.remove(researchArea);
	}

	public double getPercentComplete() {
		return percentComplete;
	}
}