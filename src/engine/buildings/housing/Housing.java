package engine.buildings.housing;

import engine.buildings.Building;
import engine.cities.CityBlock;
import engine.cities.Container;
import engine.cities.ToManyPeopleException;
import engine.people.AbstractPerson;
import engine.people.cityworkers.CityWorker;
import engine.tools.AttackableConstants;
import engine.tools.weapons.Attackable;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.ArrayList;



public abstract class Housing extends Building implements Container
{
	private int maximumOccupancy;
	private ArrayList<CityWorker> residents;
	protected Housing(AttackableConstants attackableConstants, CityBlock parentBlock) {
    	super(attackableConstants,parentBlock);
    	residents = new ArrayList<>();
		registerContainer(residents);
		if(this instanceof ApartmentBlock) {
	        maximumOccupancy = ApartmentBlock.maximumOccupancyInitial;
        }
        if(this instanceof RulersHouse) {
	        maximumOccupancy = RulersHouse.maximumOccupancyInitial;
        }
        if(this instanceof WorkersHouseBlock) {
	        maximumOccupancy = WorkersHouseBlock.maximumOccupancyInitial;
        }
    }
	public boolean overcrowdedQ() {
        int sum = getPopulation();
	    return sum <= maximumOccupancy;
    }
	public void addResidents(ArrayList<CityWorker> cityWorkers) throws ToManyPeopleException {
		int popToAdd = 0;
		for (CityWorker cityWorker : cityWorkers) {
			popToAdd += cityWorker.getPopulation();
		}
		if(getFreeSpace() >= popToAdd) {
			residents.addAll(cityWorkers);
			for (CityWorker cityWorker : cityWorkers) {
				cityWorker.setHome(this);
			}
		}
		else
			throw new ToManyPeopleException(getPopulation(), getFreeSpace());
		for (CityWorker cityWorker : cityWorkers) {
			registerContainer(cityWorker);
		}

	}
	public void removeResident(CityWorker cityWorker){
		residents.remove(cityWorker);
		deregisterContainer(cityWorker);
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
	public void remove(AbstractPerson person) {
//		assert(residents.contains(person));
		residents.remove(person);
	}
	@Override
	public void remove(Attackable attackable) {
		super.remove(attackable);// TODO: 5/24/2016 go through and check for these
		if(attackable instanceof AbstractPerson)
			remove((AbstractPerson)attackable);
	}
	@Override
	public VBox getPane() {
		VBox out =  new VBox();
		out.getChildren().add(new Text(getName()));
		out.getChildren().add(new Text("Maximum Occupancy:" + getMaximumOccupancy()));
		out.getChildren().add(new Text("Number of residents:" + getPopulation()));
		return out;
	}
	public int getMaximumOccupancy() {
		return maximumOccupancy;
	}
	public ArrayList<CityWorker> getResidents() {
		return residents;
	}

}