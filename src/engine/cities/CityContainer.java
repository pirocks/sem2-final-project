package engine.cities;

/**
 * Created by bob on 4/4/2016.
 * for destruction of engine.cities
 */
public interface CityContainer
{
	// TODO: 5/24/2016
	void remove(City city);
	default void registerCityContainer()
	{
		CityContainers.registerContainer(this);
	}
}
