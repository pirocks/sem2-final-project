package engine.science;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Discovery implements Serializable //todo maybe make interface??
{
	private double percentComplete = 0.0; //0 to 1
	private ArrayList<Discovery> required;

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
		if(percentComplete > 1.0)
			postDiscovery();
	}
	public boolean discoveredQ()
	{
		return percentComplete > 1.0;
	}
}