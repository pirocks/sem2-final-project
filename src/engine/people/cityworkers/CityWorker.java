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

import static engine.people.cityworkers.CityWorker.WhereAmI.*;

public abstract class CityWorker extends AbstractPerson implements Container//don't foret to getImage the workplace
{
	public static double travelTimeConstant = 1.0/20.0;// TODO: 5/27/2016
	public static double TimeAtWork = 0.4;
	public static double TimeAtHome = 0.5;

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
		if(home != null)
			registerContainer(home);
		hospital = getHospital();
		registerContainer(hospital);
		timeRemainingAtLocation = cityWorker.getTimeRemainingAtLocation();
		if(workplace != null)
			workplace = cityWorker.getWorkBuilding();
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
	protected void setWorkplace(Workplace workplace){
		if(this.workplace != null)
			deregisterContainer(this.workplace);
		if(workplace != null)
			registerContainer(workplace);
		this.workplace = workplace;
	}
	public void setHome(Housing home){
		this.home = home;
	}
	public enum WhereAmI {
		AtWork, AtHome, GoingToWork, GoingToHome, Initing

	}
	public void goHome() {
		double distance = 0;
		if(home != null)
			distance = home.getLocation().get(0).distanceBetween(currentBuilding.getLocation().get(0));
		whereAmI = WhereAmI.GoingToHome;
		timeRemainingAtLocation = (long)(distance*travelTimeConstant);
	}
	private void goToWork() {
		double distance = 0;
		if(currentBuilding != null)
			distance = getWorkBuilding().getLocation().get(0).distanceBetween(currentBuilding.getLocation().get(0));
		whereAmI = WhereAmI.GoingToWork;
		timeRemainingAtLocation = (long)(distance*travelTimeConstant);
	}
	private void arriveAtHome() {
		whereAmI = WhereAmI.AtHome;
		deregisterContainer(currentBuilding);
		currentBuilding = home;
		timeRemainingAtLocation = TimeAtHome;
		if(home != null)
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
		if(super.getHealth() < 0)
			die();
		if(hospital == null) {
			if (super.getHealth() < 0.3) {
				hospital = currentCity.getLeastLoadedHospital();
				currentCity.getLeastLoadedHospital().admit(this);
			}
		}
		if (super.getHealth() > 0.9 && hospital != null) {
			hospital.releasePatient(this);
			hospital = null;
		}

	}
	@Override
	public boolean sanityCheck(){
		super.sanityCheck();
		if(amIDead) {
			Liver.livers.remove(this);
			return false;
		}
//		if(getWorkBuilding() == null)
//			throw new IllegalStateException();//this really shouldn't happen but it does
		if(currentCity.getLeastLoadedHospital().getLocation() == null ) {
			throw new IllegalStateException();
		}
		if(whereAmI == Initing) {
			if(home != null){
				whereAmI = AtHome;
				currentBuilding = home;
				goHome();
			}else if(workplace != null){
				whereAmI = AtWork;
				currentBuilding = workplace;
				goToWork();
			}
			else {
				if(population < 10)
					die();
				else
						throw new IllegalStateException();
			}
			return false;
		}
		if(timeRemainingAtLocation < 0)
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
				if(planet == null){}//unable to handle but don't kill program just for that
//					throw new IllegalStateException();
				if(location.get(0).getPlanet() == null)
					location.get(0).setPlanet(planet);
			}
		}
		if(amIDead)
			throw new UnKilledObjectException();
		return true;
	}
	public void doLife(double time) {
		if(time < 0)
			throw new IllegalArgumentException();
		sanityCheck();
		checkHealth();
		deregisterContainer(currentBuilding);
		registerContainer(currentBuilding);


		//todo how does this class respond when workplace is null
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
                goHome();
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
	private void remove(City city) {
		if(currentCity == city)
			die();
	}
	private void remove(Building building) {
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
	public Workplace getWorkBuilding(){
		return workplace;
	}
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