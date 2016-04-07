package cities;

/**
 * Created by bob on 4/4/2016.
 * for destruction of cities
 */
public interface CityContainer
{
	public void remove(City city);
	default public void registerCityContainer()
	{
		CityContainers.registerContainer(this);
	}
}
