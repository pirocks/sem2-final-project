package ui.requests;

import engine.buildings.Building;
import engine.cities.City;

/**
 * Created by user on 4/13/2016.
 *
 */
public class BuildingTypeRequest extends Request
{
	private City city;
	public BuildingTypeRequest(City city){
		super();
		this.city = city;
	}

	@Override
	public void fullFillRequest() {
		// TODO: 4/13/2016 should I go through the bureacrat or detrectly add to the city?
	}

	@Override
	public void askUser() {
		// TODO: 4/13/2016 oh god this will be iratating
	}
}
