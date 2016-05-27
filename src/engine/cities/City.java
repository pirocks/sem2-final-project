package engine.cities;

import engine.buildings.Building;
import engine.buildings.UnderConstruction;
import engine.buildings.housing.ApartmentBlock;
import engine.buildings.housing.Housing;
import engine.buildings.housing.RulersHouse;
import engine.buildings.housing.WorkersHouseBlock;
import engine.buildings.workplaces.*;
import engine.people.AbstractPerson;
import engine.people.cityworkers.CityWorker;
import engine.people.cityworkers.CityWorkersConstructionContext;
import engine.planets.Grid;
import engine.planets.LocationPlanet;
import engine.planets.TerrainType;
import engine.tools.AttackableConstants;
import engine.tools.vehicles.CityBuilder;
import engine.tools.weapons.Attackable;
import engine.universe.Country;
import engine.universe.MoneySource;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by bob on 3/5/2016.
 *
 */

public class City extends Attackable implements Serializable ,Container
{
	public MoneySource moneySource;// if I don't have time this will just be the country money source//working
	// assumption as of 5/19/2016
	public static double resistanceInitial;
	public static double healthInitial;
	//remember to add stuff to the unique id if I add more member vars
	//read the above comment
//    private MoneySource moneySourceForBuildings;
	private boolean isCapital;
	private int x,y;//center of city in grid//will be townHall location
	private Grid parentGrid;//can be used to find location//engine.cities limited to one grid
	private Set<CityBlock> cityBlocks;
	private ArrayList<Hospital> hospitals;
	public ArrayList<CityWorker> residents;
	private Country parentCountry;//make sutre to change when cuity is captured.
	public String name; // TODO: 5/10/2016 go through and make all the names final or private and extract
	// interface
	public static String[] names = {
			"London", "San Francisco", "Beverly Hills","Los Altos", "Cambridge","San Jose","Edinburgh","Paris","Rome","Berlin","Moscow","Stalingrad","I'm out of clever Names","New London","Edinburgh","Boston","Lima","Leningrad","Portland",
			"Seattle","Hong Kong","Taipei","Lhasa","Sukhumi","Pristina","Hell, Michigan","Taumata whakatangi hangakoauau"
	};
	public static int nameCount = 0;
	public City(CityConstructionContext cityConstructionContext) throws ToManyPeopleException {
		super(healthInitial,resistanceInitial,cityConstructionContext.buildingLocations);
		parentGrid = cityConstructionContext.parentGrid;
		name = null;
		setName();
		cityBlocks = new HashSet<>();
		hospitals = new ArrayList<>();
		ArrayList<LocationPlanet> buildingLocations = cityConstructionContext.buildingLocations;
		for (int i = 0; i < buildingLocations.size() - 1; i++) {
			LocationPlanet locationPlanet = buildingLocations.get(i);
			Building building;
			CityBlock cityBlock = new CityBlock(this, locationPlanet.getBlockx(), locationPlanet.getBlocky());
			if (getMaximumHousingCapacity() < cityConstructionContext.population)
				building = getBuildingHousingNeeded(cityConstructionContext, cityBlock);
			else
				building = getBuildingHousingNotNeeded(cityConstructionContext, cityBlock);
			cityBlock.setBuilding(building);
			cityBlocks.add(cityBlock);
			registerContainer(cityBlock);
		}
		addHospital(buildingLocations);
		if(!(getMaximumHousingCapacity() > cityConstructionContext.population)) {
			notEnoughHousingHandler(cityConstructionContext);
		}
		for (Workplace workplace : getWorkPlaces()) {
			if(workplace.getWorkers().size() > 0)
				throw new IllegalStateException();
		}
		parentCountry = cityConstructionContext.parentCountry;
		moneySource = parentCountry;
		residents = new ArrayList<>();
		for (Workplace workplace : getWorkPlaces()) {
			if(workplace.getWorkers().size() > 0)
 				throw new IllegalStateException();
			CityWorkersConstructionContext cityWorkersConstructionContext = new CityWorkersConstructionContext(this,cityConstructionContext,workplace);
			residents.addAll(cityWorkersConstructionContext.generateWorker());
		}
	}

	private void addHospital(ArrayList<LocationPlanet> buildingLocations) {
		LocationPlanet locationPlanet =  buildingLocations.get(buildingLocations.size() - 1);
		CityBlock block = new CityBlock(this, locationPlanet.getBlockx(), locationPlanet.getBlocky());
		Hospital hospital = new Hospital(block,moneySource);
		block.setBuilding(hospital);
		cityBlocks.add(block);
		registerContainer(block);
		hospitals.add(hospital);
	}

	@NotNull
	private Building getBuildingHousingNotNeeded(CityConstructionContext cityConstructionContext, CityBlock cityBlock) {
		Building building;
		if(cityConstructionContext.type == CityConstructionContext.Type.Industrial)
			building = getBuildingIndustrialHousingNotNeeded(cityConstructionContext, cityBlock);
		else if(cityConstructionContext.type == CityConstructionContext.Type.Scientific)
			building = getBuildingScientificHousingNotNeeded(cityConstructionContext, cityBlock);
		else
			throw new UnsupportedOperationException();
		return building;
	}
	@NotNull
	private Building getBuildingIndustrialHousingNotNeeded(CityConstructionContext cityConstructionContext, CityBlock cityBlock) {
		Building building;
		double dockYardProb = 0;
		double industrialDockProb = 0;
		if(cityConstructionContext.getTerrainType() == TerrainType.Coast)
		{
			dockYardProb = 0.15;
			industrialDockProb = 0.15;
		}
		double schoolProb = 0.25;
		double hospitalProb = 0.15;
		double warehouseProb = 0.2;
		//rest is  factory
		double rand = Math.random();
		double runningTotal = dockYardProb;
		if(runningTotal > rand)
			building = new DockYard(cityBlock,cityConstructionContext.moneySourceForBuildings);
		else {
			runningTotal += industrialDockProb;
			if (runningTotal > rand)
				building = new IndustrialDock(cityBlock,cityConstructionContext.moneySourceForBuildings);
			else {
				runningTotal += schoolProb;
				if(runningTotal  > rand)
					building = new School(cityBlock,cityConstructionContext.moneySourceForBuildings);
				else {
					runningTotal += hospitalProb;
					if(runningTotal > rand) {
						building = new Hospital(cityBlock, cityConstructionContext.moneySourceForBuildings);
						hospitals.add((Hospital) building);
					}
					else{
						runningTotal += warehouseProb;
						if(runningTotal > rand)
							building = new Warehouse(cityBlock,cityConstructionContext.moneySourceForBuildings);
						else{
							building = new Factory(cityBlock,cityConstructionContext.moneySourceForBuildings);
						}
					}
				}
			}
		}
		return building;
	}
	@NotNull
	private Building getBuildingScientificHousingNotNeeded(CityConstructionContext cityConstructionContext, CityBlock cityBlock) {
		Building building;//extract redundant code
		double dockYardProb = 0;
		double industrialDockProb = 0;
		if(cityConstructionContext.getTerrainType() == TerrainType.Coast)
		{
			dockYardProb = 0.1;
			industrialDockProb = 0.1;
		}
		double schoolProb = 0.3;
		double hospitalProb = 0.15;
		double warehouseProb = 0.1;
		//rest is  research area
		double rand = Math.random();
		double runningTotal = dockYardProb;
		if(runningTotal > rand)
			building = new DockYard(cityBlock,cityConstructionContext.moneySourceForBuildings);
		else {
			runningTotal += industrialDockProb;
			if (runningTotal > rand)
				building = new IndustrialDock(cityBlock,cityConstructionContext.moneySourceForBuildings);
			else {
				runningTotal += schoolProb;
				if(runningTotal  > rand)
					building = new School(cityBlock,cityConstructionContext.moneySourceForBuildings);
				else {
					runningTotal += hospitalProb;
					if(runningTotal > rand) {
						building = new Hospital(cityBlock, cityConstructionContext.moneySourceForBuildings);
						hospitals.add((Hospital) building);
					}
					else{
						runningTotal += warehouseProb;
						if(runningTotal > rand)
							building = new Warehouse(cityBlock,cityConstructionContext.moneySourceForBuildings);
						else{
							building = new ResearchArea(cityBlock,cityConstructionContext.moneySourceForBuildings);
						}
					}
				}
			}
		}
		return building;
	}
	@NotNull
	private Building getBuildingHousingNeeded(CityConstructionContext cityConstructionContext, CityBlock cityBlock) {
		Building building;
		if (cityConstructionContext.type == CityConstructionContext.Type.Industrial) {
			//add as much housing as necessary for population
			//favor adding in outer areas
			//favor apartment blocks
			double apartmentBlockProb = 0.75;
			//rest is workers house block
			double rand = Math.random();
			if (rand < apartmentBlockProb)
				building = new ApartmentBlock(cityBlock);                    //apartment
			else
				building = new WorkersHouseBlock(cityBlock); //workers house block

		} else if (cityConstructionContext.type == CityConstructionContext.Type.Scientific) {
			//add as much huosing as necesary
			//favor adding in uter areas
			//favor housing
			double housingProb = 0.8;// TODO: 5/10/2016 magic constants
			//workers houseing is the rest.
			double rand = Math.random();
			if (rand < housingProb)
				building = new WorkersHouseBlock(cityBlock);//build a workersHouse block
			else
				building = new ApartmentBlock(cityBlock);//build a new apartment
		} else//possibly add capital city
			throw new UnsupportedOperationException();// this is really a npt implemented exception but java doesn't have that
		return building;
	}
	public City(CityBuilder cityBuilder){
		super(new AttackableConstants(healthInitial,resistanceInitial,cityBuilder.getLocation()));// TODO: 5/26/2016 add all building locations
		moneySource = cityBuilder.getParentCountry();
		CityBlock cityBlockTownHall = new CityBlock(this,49,49);
		setBuilding(new TownHall(cityBlockTownHall,moneySource));
		LocationPlanet warehouseLocation = new LocationPlanet(parentGrid,49,48);
		CityBlock cityBlockWarehouse = new CityBlock(this,49,48);
		setBuilding(new Warehouse(cityBlockWarehouse,moneySource));
		LocationPlanet apartmentLocation = new LocationPlanet(parentGrid,49,47);
		CityBlock apartmentBlock = new CityBlock(this,x,y);
		name = null;
		setName();
	}
	private void notEnoughHousingHandler(CityConstructionContext c) {
		if(getMaximumHousingCapacity() > c.population)
			return;
		Workplace w = null;
		try {
			w = getWorkPlaces().get(0);
		} catch (IndexOutOfBoundsException e) {
			//this shouldn't happen
			//but if it does get rid of people
			System.out.println("city:" + name);
			System.out.println("population:" + c.population);
			System.out.println(getBuilding());
			if(c.population > 1000)
				c.population -= 1000;
			else
				c.population -= 1;
			notEnoughHousingHandler(c);
			return;
		}
		CityBlock block = w.getParentBlock();
		w.die();
		block.setBuilding(new ApartmentBlock(block));
		if (getMaximumHousingCapacity() <  c.population)
			notEnoughHousingHandler(c);
	}
	public void buildBuilding(UnderConstruction building) {
		CityBlock block = building.getParentBlock();
		cityBlocks.add(block);
		block.setBuilding(building.getBuilding());

	}
	public ArrayList<Housing> getHousing() {
		ArrayList<Housing> out = new ArrayList<>();
		for(CityBlock block:cityBlocks)
			if(block.getBuilding() instanceof Housing)
				out.add((Housing)block.getBuilding());
		return out;
	}
	public ArrayList<Building> getBuilding() {
		ArrayList<Building> out = new ArrayList<>();
		for(CityBlock block:cityBlocks)
			out.add(block.getBuilding());
		return out;
	}
	public void setName() {
		try {
			name = names[nameCount];
		} catch (Exception e) {
			name = "City#" + nameCount;
		}
		nameCount++;
	}
	public Set<CityBlock> getCityBlocks() {
		return cityBlocks;
	}
	public Building getCapitalBuilding() {
		assert(isCapital);
		for(CityBlock cityBlock:cityBlocks)
			if(cityBlock.getBuilding() instanceof RulersHouse)
				return cityBlock.getBuilding();
		assert(false);
		return null;
	}
	public double getXInPlanet() {
		double GridX = (double)parentGrid.getX();
		return GridX + x/100.0;
	}
	public double getYInPlanet() {
		double GridY = (double)parentGrid.getY();
		return GridY + y/100.0;
	}
	public Country getParentCountry()
	{
		return parentCountry;
	}
	public Grid getGrid() {
		return parentGrid;
	}
	public double getXInGrid() {
		return x;
	}
	public double getYInGrid() {
		return y;
	}
	public Hospital getLeastLoadedHospital() {
		Hospital leastLoadedHospital = hospitals.get(0);
		for(Hospital hospital:hospitals)
			if(leastLoadedHospital.getWorkLoad() > hospital.getWorkLoad())
				leastLoadedHospital = hospital;
		return leastLoadedHospital;
	}
	public void leavePerson(AbstractPerson person) {
		for(Hospital hospital:hospitals) {
			hospital.leavePerson(person);
		}
		assert(residents.contains(person));
		residents.remove(person);
	}
	//all people that are homeless are also jobless
	public ArrayList<CityWorker> getHomeless(){
		ArrayList<CityWorker> out = new ArrayList<>();
		for(CityWorker worker:residents)
		{
			if(worker.getHome() == null)
				out.add(worker);
		}
		return out;
	}
	public ArrayList<CityWorker> getJobLess(){
		ArrayList<CityWorker> out = new ArrayList<>();
		for(CityWorker worker:residents) {
			worker.doLife(0);//garuntees that everything in the class is in order
			if (worker.getWorkBuilding() == null)
				out.add(worker);
		}
		return out;
	}
	public double getJobLessCount() {
		double out = 0;
		for (CityWorker cityWorker : getJobLess()) {
			out += cityWorker.getPopulation();
		}
		return out;
	}
	public double getHomeLessCount() {
		double out = 0;
		for (CityWorker cityWorker : getJobLess()) {
			out += cityWorker.getPopulation();
		}
		return out;
	}
	public Housing findEmptyHousing(int minimumFree){
		for(CityBlock block:cityBlocks){
			if(block.getBuilding() instanceof Housing)
				if(((Housing) block.getBuilding()).getFreeSpace() >= minimumFree)
					return (Housing) block.getBuilding();
		}
		return null;
	}
	public int getMaximumHousingCapacity() {
		int out = 0;
		for(CityBlock block:cityBlocks)
		{
			if(block.getBuilding() instanceof Housing)
			{
				Housing housing = (Housing) block.getBuilding();
				out += housing.getMaximumOccupancy();
			}
		}
		return out;
	}
	public void doLife(long time){
		for(CityWorker worker: residents)
		{
			worker.doLife(time);//// TODO: 4/13/2016 bureucrats and rulers should run the city

			//// TODO: 4/27/2016
			//more stuff:
			/*
		things that the should do list
			 */
		}
	}
	public void remove(Building building) {
		for(CityBlock cityBlock:cityBlocks)
			cityBlock.remove(building);
		hospitals.remove(building);
	}
	public void remove(AbstractPerson person) {
		residents.remove(person);
	}
	//TODO: if damage is greater than a certain number pass to city otherwise go to random cityblock
	@Override
	public void die() {
		super.die();
		for (CityBlock cityBlock : cityBlocks) {
			cityBlock.die();
		}
		for (CityWorker resident : residents) {
			resident.die();
		}
		for (Hospital hospital : hospitals) {
			hospital.die();
//todo make sure all has this
		}
	}
	public Grid getParentGrid() {
		return parentGrid;
	}
	public ArrayList<Workplace> getWorkPlaces() {
		ArrayList<Workplace> out = new ArrayList<>();
		for(Building building:getBuilding())
			if(building instanceof Workplace)
				out.add((Workplace)building);
		return out;
	}
	public MoneySource getMoneySource() {
		return moneySource;
	}
	public void setBuilding(Building building) {
		CityBlock block = building.getParentBlock();
		block.setBuilding(building);
	}
	@Override
	public void remove(Attackable attackable) {
		if(attackable instanceof Building)
			remove((Building)attackable);
		if(attackable instanceof AbstractPerson)
			remove((AbstractPerson)attackable);
	}
	public void registerCityBlock(CityBlock block) {
		if(block.getParentCity() != this)
			throw new IllegalArgumentException();
		cityBlocks.add(block);
	}
}
