package engine.people.cityworkers;

import engine.buildings.housing.Housing;
import engine.buildings.workplaces.InCorrectWorkerTypeException;
import engine.buildings.workplaces.ToManyWorkersException;
import engine.buildings.workplaces.Workplace;
import engine.cities.City;
import engine.cities.CityConstructionContext;
import engine.cities.ToManyPeopleException;

import java.util.ArrayList;

/**
 * Created by bob on 5/26/2016.
 */
public class CityWorkersConstructionContext {

	private City city;
	private Workplace workplace;
	private CityConstructionContext c;
	public CityWorkersConstructionContext(City city, CityConstructionContext c, Workplace workplace) {
		this.c = c;
		this.city = city;
		this.workplace = workplace;
		if(workplace.getWorkers().size() > 0)
			throw new IllegalStateException();
	}

	public ArrayList<CityWorker> generateWorker() {
		if(workplace.getWorkers().size() > 0)
			throw new IllegalStateException();
		ArrayList<CityWorker> out = new ArrayList<>();
		out.add(workplace.createCorrectType());
		for (CityWorker cityWorker : out) {
			assignWorkerToWorkplace(cityWorker);
		}
		for (int i = 0; i < out.size(); i++) {
			CityWorker cityWorker = out.get(i);
			assignWorkerToHousing(out,cityWorker);
		}
		return out;
	}

	public void assignWorkerToWorkplace(CityWorker cityWorker) {
		try {
			cityWorker.setPopulation(workplace.getMaxWorkers());
			if(workplace.getWorkers().size() > 0)
				throw new IllegalStateException();
			workplace.addWorker(cityWorker);
		}
		catch (InCorrectWorkerTypeException e) {
			throw new IllegalStateException();
		} catch (ToManyWorkersException e) {
			e.printStackTrace();
		}
	}
	public void assignWorkerToHousing(ArrayList<CityWorker> out,CityWorker cityWorker){
		/*
		* precondition: there is enough housing for every worker.
		* iterate over housing and ver workers in conjunction
		* split workers to fit
		* the split operator needs to be created in abstractperson/cityworker/al subclases
		* */
		Housing emptyHousing = city.findEmptyHousing(1);
		if(emptyHousing == null){
			throw new IllegalStateException();
		}
		else{
			int popa = emptyHousing.getFreeSpace();
			int popb = cityWorker.getPopulation() - popa;
			out.add(cityWorker.split(popa,popb));
			try {
				emptyHousing.addResidents(new ArrayList<CityWorker>(){{add(cityWorker);}});
			} catch (ToManyPeopleException e) {
				throw new IllegalStateException();
			}
		}
	}
}
