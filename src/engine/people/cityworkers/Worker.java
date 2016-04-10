package engine.people.cityworkers;

import engine.buildings.housing.Housing;
import engine.buildings.workplaces.Workplace;
import engine.cities.City;

/**
 * Created by bob on 4/10/2016.
 *
 */
public class Worker extends CityWorker
{

	public Worker(City city, Housing home) {
		super(city, home);
	}

	@Override
	public Workplace getWorkBuilding() {
		return null;// TODO: 4/10/2016
	}

	@Override
	public void setWorkPlaceToNull() {
		// TODO: 4/10/2016  //what the fuck is this method
	}

	@Override
	public void doSkill(long time) {
		// TODO: 4/10/2016
	}

	@Override
	public double getWeight() {
		return 0;// TODO: 4/10/2016
	}
}
