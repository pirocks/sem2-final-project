package engine.cities;

import engine.buildings.Building;
import engine.buildings.BuildingContainer;
import engine.buildings.housing.ApartmentBlock;
import engine.buildings.housing.Housing;
import engine.buildings.housing.RulersHouse;
import engine.buildings.housing.WorkersHouseBlock;
import engine.buildings.workplaces.*;
import engine.people.AbstractPerson;
import engine.people.PersonContainer;
import engine.people.cityworkers.CityWorker;
import engine.planets.Grid;
import engine.planets.LocationPlanet;
import engine.planets.TerrainType;
import engine.tools.weapons.Attackable;
import engine.universe.Country;
import engine.universe.CountryContainer;
import engine.universe.MoneySource;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by bob on 3/5/2016.
 *
 */

public class City extends Attackable implements Serializable ,BuildingContainer, CountryContainer, PersonContainer
{
	public MoneySource moneySource;// if I don't have time this will just be the country money source
	public static double resistanceInitial;
	public static double healthInitial;
	//remember to add stuff to the unique id if I add more member vars
	//read the above comment
//    private MoneySource moneySourceForBuildings;
	private boolean isCapital;
	private int x,y;//center of city in grid//will be townHall location
	private Grid parentGrid;//can be used to find location//engine.cities limited to one grid
	// private ArrayList<Grid> grids;//not yet
	private ArrayList<CityBlock> cityBlocks;
	private ArrayList<Hospital> hospitals;
	public ArrayList<CityWorker> residents;
//    public ArrayList<CityWorker> unemployedResidents;
	private Country parentCountry;//make sutre to change when cuity is captured.
	public String name; // TODO: 5/10/2016 go through and make all the names final or private and extract interface
	public static String[] names = {
			"London", "San Francisco", "Beverly Hills","Los Altos", "Cambridge","San Jose","Edinburgh","Paris","Rome","Berlin","Moscow","Stalingrad","I'm out of clever Names","New London","Edinburgh","Boston","Lima","Leningrad","Portland",
			"Seattle","Hong Kong","Taipei","Lhasa","Sukhumi","Pristina","Hell, Michigan","Taumata whakatangi hangakoauau"
	};
	public static int nameCount = 0;

	public City(CityConstructionContext cityConstructionContext) throws ToManyPeopleException {
		super(healthInitial,resistanceInitial,cityConstructionContext.buildingLocations);
		parentGrid = cityConstructionContext.parentGrid;
		setName();
		cityBlocks = new ArrayList<>();
		hospitals = new ArrayList<>();
		for(LocationPlanet locationPlanet:cityConstructionContext.buildingLocations)
		{
			Building building;
			CityBlock cityBlock = new CityBlock(null,cityConstructionContext.parentGrid,null,this,locationPlanet.getBlockx(),locationPlanet.getBlocky());
			//each building will be build here
//			System.out.print("maximum capacity" + getMaximumHousingCapacity() + "pop:" + cityConstructionContext.population);
			if(getMaximumHousingCapacity() < cityConstructionContext.population)
			{
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

			}
			else
			{
				//factories etc:
				if(cityConstructionContext.type == CityConstructionContext.Type.Industrial)
				{
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
				}
				else if(cityConstructionContext.type == CityConstructionContext.Type.Scientific)
				{
					//extract redundant code
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
				}
				else
				{
					throw new UnsupportedOperationException();
				}
			}
			cityBlock.setBuilding(building);
			cityBlocks.add(cityBlock);
		}
		if(!(getMaximumHousingCapacity() > cityConstructionContext.population)) {
			notEnoughHousingHandler(cityConstructionContext);
		}
		parentCountry = cityConstructionContext.parentCountry;
		residents = new ArrayList<>();
		// TODO: 5/8/2016 implement me residents
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

	public ArrayList<Housing> getHousing()
	{
		ArrayList<Housing> out = new ArrayList<>();
		for(CityBlock block:cityBlocks)
			if(block.getBuilding() instanceof Housing)
				out.add((Housing)block.getBuilding());
		return out;
	}
	public ArrayList<Building> getBuilding()
	{
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
	public ArrayList<CityBlock> getCityBlocks()
	{
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
	public Grid getGrid()
	{
		return parentGrid;
	}
	public double getXInGrid()
	{
		return x;
	}
	public double getYInGrid()
	{
		return y;
	}
	public Hospital getLeastLoadedHosital() {
		Hospital leastLoadedHospital = hospitals.get(0);
		for(Hospital hospital:hospitals)
			if(leastLoadedHospital.getWorkLoad() > hospital.getWorkLoad())
				leastLoadedHospital = hospital;
		return leastLoadedHospital;
	}
	public void leavePerson(AbstractPerson person) {
		for(Hospital hospital:hospitals)
		{
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
	@Override
	public void remove(Building building) {
		for(CityBlock cityBlock:cityBlocks)
			cityBlock.remove(building);
		hospitals.remove(building);
	}
	@Override
	public void remove(AbstractPerson person) {
		residents.remove(person);
	}
	@Override
	public void remove(Country country,Country conqueror) {
		if(parentCountry == country) {
			parentCountry = conqueror;
		}
	}
	//TODO: if damage is greater than a certain number pass to city otherwise go to random cityblock
//	@Override
//	public boolean receiveDamage(double damage) {
//		return attackableConstants.receiveDamage(damage,this);
//	}

	@Override
	public void die() {
		CityContainers.remove(this);// TODO: 4/9/2016 make sure that this kills everything

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
}
