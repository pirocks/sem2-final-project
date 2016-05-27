package engine.people.cityworkers;

import engine.buildings.workplaces.Workplace;
import engine.cities.City;
import engine.cities.CityConstructionContext;

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
	}

	public CityWorker generateWorker() {
		CityWorker out = workplace.createCorrectType();
		return out;// TODO: 5/26/2016 postprocessing everyrhing in order
	}
}
