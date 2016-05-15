package engine.buildings.housing;

import engine.buildings.Building;
import engine.cities.CityBlock;
import engine.people.AbstractPerson;
import engine.people.PersonContainer;
import engine.people.cityworkers.CityWorker;
import engine.tools.AttackableConstants;

import java.util.ArrayList;



public abstract class Housing extends Building implements PersonContainer
{
	private int maximumOccupancy;

	private ArrayList<CityWorker> residents;
	public Housing(AttackableConstants attackableConstants, CityBlock parentBlock) {
    	super(attackableConstants,parentBlock);
	    registerPersonContainer();
    	residents = new ArrayList<>();
        if(this instanceof ApartmentBlock) {
	        maximumOccupancy = ApartmentBlock.maximumOccupancyInitial;
        }
        if(this instanceof RulersHouse) {
	        maximumOccupancy = RulersHouse.maximumOccupancyInitial;
        }
// 		if(this instanceof WealthWorkersHouseBlock){
// 			maximumOccupancy = WealthWorkersHouseBlock.maximumOccupancyInitial;
//	    }
        if(this instanceof WorkersHouseBlock) {
	        maximumOccupancy = WorkersHouseBlock.maximumOccupancyInitial;
        }
    }


	public boolean overcrowdedQ() {
        int sum = getPopulation();
	    return sum <= maximumOccupancy;
    }
	public int getPopulation() {
        int sum = 0;
        for(CityWorker person:residents)
            sum += person.getPopulation();
        return sum;
    }
	public int getFreeSpace() {
		return maximumOccupancy - getPopulation();
	}
	@Override
	public void remove(AbstractPerson person) {
//		assert(residents.contains(person));
		residents.remove(person);
	}
	public int getMaximumOccupancy() {
		return maximumOccupancy;
	}

	public ArrayList<CityWorker> getResidents() {
		return residents;
	}
}