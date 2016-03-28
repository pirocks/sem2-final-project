public abstract class Discovery//maybe make interface??
{
	private double percentComplete = 0.0; //0 to 1
	public abstract void postDiscovery();
	public void makeProgress(double progress)
	{
		percentComplete += progress;
		if(percentComplete > 1.0)
			postDiscovery();
	}
	public boolean discoveredQ()
	{
		if(percentComplete > 1.0)
			return true;
		return false;
	}
}