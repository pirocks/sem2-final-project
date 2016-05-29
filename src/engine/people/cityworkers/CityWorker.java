package engine.people.cityworkers;

import engine.buildings.Building;
import engine.buildings.housing.Housing;
import engine.buildings.workplaces.Hospital;
import engine.buildings.workplaces.Workplace;
import engine.cities.City;
import engine.cities.Container;
import engine.people.AbstractPerson;
import engine.planets.Planet;
import engine.tools.vehicles.Liver;
import engine.tools.weapons.Attackable;

import static engine.people.cityworkers.CityWorker.WhereAmI.AtHome;
import static engine.people.cityworkers.CityWorker.WhereAmI.Initing;

public abstract class CityWorker extends AbstractPerson implements Container, Cloneable//don't foret to get the workplace
{
	public static long travelTimeConstant;// TODO: 5/27/2016
	public static long TimeAtWork;// TODO: 5/27/2016
	public static long TimeAtHome;// TODO: 5/27/2016

	protected WhereAmI whereAmI;
	private Building currentBuilding;// TODO: 5/29/2016 check registration for these
	private Housing home = null;// TODO: 5/29/2016 check registration for these
	private City currentCity;// TODO: 5/29/2016 check registration for these //should be renamed to parent city
	protected double timeRemainingAtLocation;
	private Hospital hospital;// TODO: 5/29/2016 check registration for these  //is null if not going to hospital
	private Workplace workplace;
	public CityWorker(PeopleInitialConstants peopleInitialConstants,City city) {
		super(peopleInitialConstants);
		currentCity = city;
		registerContainer(city);
		whereAmI = Initing;
	}
	public CityWorker(CityWorker cityWorker) {
		super(cityWorker);
		whereAmI = cityWorker.whereAmI;
		currentCity = cityWorker.currentCity;
		registerContainer(currentCity);
		currentBuilding = cityWorker.getCurrentBuilding();
		registerContainer(currentBuilding);
		home = getHome();
		registerContainer(home);
		hospital = getHospital();
		registerContainer(hospital);
		timeRemainingAtLocation = cityWorker.getTimeRemainingAtLocation();
	}
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
		AtWork, AtHome, GoingToWork, GoingToHome, Initing

	}
	public void goHome() {
		double distance = home.getLocation().get(0).distanceBetween(currentBuilding.getLocation().get(0));
		whereAmI = WhereAmI.GoingToHome;
		timeRemainingAtLocation = (long)(distance*travelTimeConstant);
	}
	private void goToWork() {
		double distance = getWorkBuilding().getLocation().get(0).distanceBetween(currentBuilding.getLocation().get(0));
		whereAmI = WhereAmI.GoingToWork;
		timeRemainingAtLocation = (long)(distance*travelTimeConstant);
	}
	private void arriveAtHome() {
		whereAmI = WhereAmI.AtHome;
		deregisterContainer(currentBuilding);
		currentBuilding = home;
		timeRemainingAtLocation = TimeAtHome;
		home.registerContainer(this);
	}
	private void arriveAtWork() {
		whereAmI = WhereAmI.AtWork;
		deregisterContainer(currentBuilding);
		currentBuilding = getWorkBuilding();
		timeRemainingAtLocation = TimeAtWork;
		currentBuilding.registerContainer(this);
	}
	public void leaveHospital() {
		hospital = null;
		goHome();
	}
	public void checkHealth() {
		if(super.getHealth() < 0.3) {
			hospital = currentCity.getLeastLoadedHospital();
			currentCity.getLeastLoadedHospital().admit(this);
		}
		if(super.getHealth() > 0.9 && hospital != null){
			hospital.releasePatient(this);
			hospital = null;
		}

	}
	@Override
	public boolean sanityCheck(){
		if(amIDead) {
			Liver.livers.remove(this);
			return false;
		}
		if(currentCity.getLeastLoadedHospital().getLocation() == null ) {
			throw new IllegalStateException();
		}
		if(whereAmI == Initing) {
			if(home != null){
				whereAmI = AtHome;
				currentBuilding = home;
				goHome();
			}
			else
				throw new IllegalStateException();
			return false;
		}
		if(currentBuilding == null) {
			if(home != null){
				whereAmI = AtHome;
				currentBuilding = home;
				goHome();
			}
			else
				throw new IllegalStateException();
			return false;
		}
		if(timeRemainingAtLocation < 0)
			throw new IllegalStateException();
		if(home == null)
			throw new IllegalStateException();
		if(currentCity == null)
			throw new IllegalStateException();
		if(population <= 0)
			throw new IllegalStateException();
		if(moneySource == null)
			throw new IllegalStateException();
		if(location == null)
			throw new IllegalStateException();
		if(location.size() != 1)
			throw new IllegalStateException();
		try {
			if (location.get(0).getGrid() != getWorkBuilding().getGrid()) {
				throw new IllegalStateException();
			}
		}catch (NullPointerException e){
			//assume that this is caused by a planet null pointer exception
			Planet planet = currentCity.getLocation().get(0).getPlanet();
			if(planet == null)
				throw new IllegalStateException();
			if (location.get(0).getPlanet() == null) {
				location.get(0).setPlanet(planet);
			}
		}
		try{
			if(location.get(0).getGrid() != getHome().getGrid())
				throw new IllegalStateException();
		}catch (NullPointerException e){
			if(getHome() != null){
				Planet planet = currentBuilding.getLocation().get(0).getPlanet();
				if(planet == null)
					throw new IllegalStateException();
				if(location.get(0).getPlanet() == null)
					location.get(0).setPlanet(planet);
			}
		}
		if(amIDead())
			throw new UnKilledObjectException();
		return true;
	}
	public void doLife(double time) {
		sanityCheck();
		checkHealth();
		registerContainer(currentBuilding);
		//todo how does this class respond when workplace is null
		if(time < 1)
            return;
		if(timeRemainingAtLocation >= time)
        {
        	if(whereAmI == WhereAmI.AtWork) {
        		doSkill(time);
        		assert(getWorkBuilding() == currentBuilding);
        	}
            timeRemainingAtLocation -= time;
            return;
        }
		if(home == null)
			increaseHealth(-0.1);
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
            case AtHome:
                time -= timeRemainingAtLocation;
                goToWork();
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
			die();
		}
		if(home == building)
		{
			home = null;
		}
		if(hospital == building)
		{
			hospital = null;
		}
		if(getWorkBuilding() == building)
		{
			setWorkplace(null);
		}
	}
	public abstract Workplace getWorkBuilding();
	public abstract void doSkill(double time);
	public Building getCurrentBuilding() {
		return currentBuilding;
	}
	public Hospital getHospital() {
		return hospital;
	}
	public double getTimeRemainingAtLocation() {
		return timeRemainingAtLocation;
	}
	public CityWorker split(int popa,int popb){
		if(popa > population ||popb > population)
			throw new IllegalArgumentException();
		if(popa <= 0 & popb <= 0 )
			throw new IllegalArgumentException();
		if(popa + popb != population)
			throw new IllegalArgumentException();
		this.population = popa;
		CityWorker out = splitInternal();
		out.setPopulation(popb);
		return out;
	}
	protected abstract CityWorker splitInternal();
}