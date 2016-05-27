package engine.people.cityworkers;

import engine.buildings.Building;
import engine.buildings.housing.Housing;
import engine.buildings.workplaces.Hospital;
import engine.buildings.workplaces.Workplace;
import engine.cities.City;
import engine.cities.Container;
import engine.people.AbstractPerson;
import engine.tools.weapons.Attackable;

import static engine.people.cityworkers.CityWorker.WhereAmI.Initing;

public abstract class CityWorker extends AbstractPerson implements Container, Cloneable//don't foret to get the workplace
{
	public static long travelTimeConstant;
	public static long TimeAtWork;
	public static long TimeAtHome;

	@Override
	public void remove(Attackable attackable) {
		if(attackable instanceof Building)
			remove((Building)attackable);
		if(attackable instanceof City)
			remove((City)attackable);
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	public void registerWorkplace(Workplace workplace){
		setWorkplace(workplace);
	}
	protected abstract void setWorkplace(Workplace workplace);

	public void setHome(Housing home){
		this.home = home;
	}

	public enum WhereAmI {
		AtWork,AtHospital,AtHome,GoingToWork,GoingToHospital,GoingToHome,Initing
	}
	protected WhereAmI whereAmI;
	private Building currentBuilding;
	private Housing home = null;
    private City currentCity;//should be renamed to parent city
	protected long timeRemainingAtLocation;
	private Hospital hospital; //is null if not going to hospital
	public CityWorker(PeopleInitialConstants peopleInitialConstants,City city) {
		super(peopleInitialConstants);
		currentCity = city;
		registerContainer(city);
		whereAmI = Initing;
	}
	public void goHome() {
		double distance = home.getLocation().get(0).distanceBetween(currentBuilding.getLocation().get(0));
		whereAmI = WhereAmI.GoingToHome;
		currentBuilding = null;
		timeRemainingAtLocation = (long)(distance*travelTimeConstant);
	}
	private void goToWork() {
		double distance = getWorkBuilding().getLocation().get(0).distanceBetween(currentBuilding.getLocation().get(0));
		whereAmI = WhereAmI.GoingToWork;
		currentBuilding = null;
		timeRemainingAtLocation = (long)(distance*travelTimeConstant);
	}
	private void goToHospital() {
		Hospital h = currentCity.getLeastLoadedHospital();
		double distance = h.getLocation().get(0).distanceBetween(currentBuilding.getLocation().get(0));
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
	@Override
	public void sanityCheck(){
		if(salaryGiver == null)
			throw new IllegalStateException();
		if(amIDead)
			throw new UnKilledObjectException();


	}
	public void doLife(long time) {
		checkHealth();
		registerContainer(currentBuilding);
		if(home == null)
			setWorkPlaceToNull();
		//todo how does this class respond when workplace is null
		if(time < 1)
            return;
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
	public Housing getHome(){
		return home;
	}
	@Override
	public void dieSpecific() {
		if(!amIDead)
			Container.kill(this);
	}
	public void remove(City city) {
		if(currentCity == city)
			die();
	}
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