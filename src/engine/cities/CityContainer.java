package engine.cities;

import java.util.ArrayList;

/**
 * Created by bob on 4/4/2016.
 * for destruction of engine.cities
 */
public interface CityContainer
{
	void remove(City city);
	default void registerCityContainer()
	{
		registerContainer(this);
	}
	ArrayList<CityContainer> containers = new ArrayList<CityContainer>();
	static void registerContainer(CityContainer in)
	{
		containers.add(in);
	}
	static void killCity(City in) {
		for(CityContainer container:containers)
		{
			container.remove(in);
		}
	}
}
