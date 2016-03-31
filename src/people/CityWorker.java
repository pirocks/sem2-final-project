














package people;


import cities.*;
import buildings.workplaces.*;
import buildings.*;
import buildings.housing.*;
import planets.*;
import java.util.ArrayList;


public abstract class CityWorker extends AbstractPerson
{
	public static long travelTimeConstant;
	public static long TimeAtWork;
	public static long TimeAtHome;
	public static enum WhereAmI
	{
		AtWork,AtHospital,AtHome,GoingToWork,GoingToHospital,GoingToHome
	}
	protected WhereAmI whereAmI;
	private Building currentBuilding;
	private Housing home;
	public abstract Workplace getWorkBuilding();
	public abstract void doSkill(long time);
    private City currentCity;//should be renamed to parent city
	protected long timeRemainingAtLocation;
	Hospital hospital; //is null if not going to hospital
	public CityWorker(AbstractPerson.Type type,City city,Housing home)
	{
		super(type,city.getParentCountry());
		this.home = home;
		currentCity = city;
	}
	//deprecated
	// public static double distanceBetweenBuildings(Building a, Building b)
	// {
	// 	assert(a.getParentCity() == b.getParentCity());
	// 	double xDiff = a.getXInGrid() - b.getXInGrid();
	// 	double yDiff = a.getYInGrid() - b.getYInGrid();
	// 	return Math.sqrt(yDiff*yDiff + xDiff*xDiff);
	// }
	private void goHome()
	{
		double distance = home.getLocation().distanceBetween(currentBuilding.getLocation());
		whereAmI = WhereAmI.GoingToHome;
		currentBuilding = null;
		timeRemainingAtLocation = (long)(distance*travelTimeConstant);
	}
	private void goToWork()
	{
		double distance = getWorkBuilding().getLocation().distanceBetween(currentBuilding.getLocation());
		whereAmI = WhereAmI.GoingToWork;
		currentBuilding = null;
		timeRemainingAtLocation = (long)(distance*travelTimeConstant);
	}
	private void goToHospital()
	{
		Hospital h = currentCity.getLeastLoadedHosital();
		double distance = h.getLocation().distanceBetween(currentBuilding.getLocation());
		whereAmI = WhereAmI.GoingToHospital;
		currentBuilding = null;
		timeRemainingAtLocation = (long)(distance*travelTimeConstant);
		hospital = h;
	}
	private void arriveAtHome()
	{
		whereAmI = WhereAmI.AtHome;
		currentBuilding = home;
		timeRemainingAtLocation = TimeAtHome;
	}
	private void arriveAtWork()
	{
		whereAmI = WhereAmI.AtWork;
		currentBuilding = getWorkBuilding();
		timeRemainingAtLocation = TimeAtWork;
	}
	private void arriveAtHospital()
	{
		whereAmI = WhereAmI.AtHospital;
		currentBuilding = hospital;
		timeRemainingAtLocation = Long.MAX_VALUE;
		hospital.admit(this);
	}
	public void leaveHospital()
	{
		hospital = null;
		goHome();
	}
	public void checkHealth()
	{
		if(super.getHealth() < 0.3)
			goToHospital();
	}
	public void doLife(long time)
	{
		if(time < 1)
            return;
        checkHealth();
        if(timeRemainingAtLocation >= time)
        {
        	if(whereAmI == WhereAmI.AtWork)
        	{
        		doSkill(time);
        		assert(getWorkBuilding() == currentBuilding);
        	}
            timeRemainingAtLocation -= time;
            return;
        }
        switch(whereAmI)
        {
            case GoingToHome:
                time -= timeRemainingAtLocation;
                arriveAtHome();
                doLife(time);
                break;
            case GoingToWork:
                time -= timeRemainingAtLocation;
                arriveAtWork();
                doLife(time);
                break;
            case GoingToHospital:
                time -= timeRemainingAtLocation;
                arriveAtHospital();
                doLife(time);
                break;
            case AtHome:
                time -= timeRemainingAtLocation;
                goToWork();
                doLife(time);
                break;
            case AtHospital:
            	assert(false);//will never happen
                time -= timeRemainingAtLocation;
                doLife(time);
                break;
            case AtWork:
            	doSkill(timeRemainingAtLocation);
                time -= timeRemainingAtLocation;
                doLife(time);
                break;
        }

	}
}