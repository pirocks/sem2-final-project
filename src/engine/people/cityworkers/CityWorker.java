package engine.people.cityworkers;

import engine.buildings.Building;
import engine.buildings.BuildingContainer;
import engine.buildings.housing.Housing;
import engine.buildings.workplaces.Hospital;
import engine.buildings.workplaces.Workplace;
import engine.cities.City;
import engine.cities.CityContainer;
import engine.people.AbstractPerson;
import engine.people.PersonContainers;

public abstract class CityWorker extends AbstractPerson implements BuildingContainer, CityContainer//don't foret to get the workplace
{
	public static long travelTimeConstant;
	public static long TimeAtWork;
	public static long TimeAtHome;
	public enum WhereAmI {
		AtWork,AtHospital,AtHome,GoingToWork,GoingToHospital,GoingToHome
	}
	protected WhereAmI whereAmI;
	private Building currentBuilding;
	private Housing home;
    private City currentCity;//should be renamed to parent city
	protected long timeRemainingAtLocation;
	private Hospital hospital; //is null if not going to hospital
	public CityWorker(PeopleInitialConstants peopleInitialConstants,City city) {
		super(peopleInitialConstants);
		registerCityContainer();
		registerBuildingContainer();
//		this.home = home;
		currentCity = city;
	}
	public void goHome() {
		double distance = home.getLocation().distanceBetween(currentBuilding.getLocation());
		whereAmI = WhereAmI.GoingToHome;
		currentBuilding = null;
		timeRemainingAtLocation = (long)(distance*travelTimeConstant);
	}
	private void goToWork() {
		double distance = getWorkBuilding().getLocation().distanceBetween(currentBuilding.getLocation());
		whereAmI = WhereAmI.GoingToWork;
		currentBuilding = null;
		timeRemainingAtLocation = (long)(distance*travelTimeConstant);
	}
	private void goToHospital() {
		Hospital h = currentCity.getLeastLoadedHosital();
		double distance = h.getLocation().distanceBetween(currentBuilding.getLocation());
		whereAmI = WhereAmI.GoingToHospital;
		currentBuilding = null;
		timeRemainingAtLocation = (long)(distance*travelTimeConstant);
		hospital = h;
	}
	private void arriveAtHome() {
		whereAmI = WhereAmI.AtHome;
		currentBuilding = home;
		timeRemainingAtLocation = TimeAtHome;
	}
	private void arriveAtWork() {
		whereAmI = WhereAmI.AtWork;
		currentBuilding = getWorkBuilding();
		timeRemainingAtLocation = TimeAtWork;
	}
	private void arriveAtHospital() {
		whereAmI = WhereAmI.AtHospital;
		currentBuilding = hospital;
		timeRemainingAtLocation = Long.MAX_VALUE;
		hospital.admit(this);
	}
	public void leaveHospital() {
		hospital = null;
		goHome();
	}
	public void checkHealth() {
		if(super.getHealth() < 0.3)
			goToHospital();
	}
	public void doLife(long time) {
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
	@Override
	public void dieSpecific()
	{
		PersonContainers.remove(this);
	}
	//TODO: figure out how cityless workers work//they don't//whats more intersiting is workers that ar on roads when city is destroyed
	@Override
	public void remove(City city) {
		//todo what about workers on roads.
		if(currentCity == city)
			die();
	}
	@Override
	public void remove(Building building) {
		if(currentBuilding == building) {
			die();//not sure about this
			currentBuilding = null;
		}
		if(home == building)
		{
			//TODO:homeless
		}
		if(hospital == building)
		{
			//should be dead right//however above has handled it
			assert(super.amIDead());
			hospital = null;
		}
		if(getWorkBuilding() == building)
		{
			setWorkPlaceToNull();
		}
	}
	public abstract Workplace getWorkBuilding();
	public abstract void setWorkPlaceToNull();
	public abstract void doSkill(long time);
}