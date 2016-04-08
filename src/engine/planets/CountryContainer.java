package engine.planets;

/**
 * Created by bob on 4/5/2016.
 *
 */
public interface CountryContainer {
	public void remove(Country country);
	default public void registerCountryContainer()
	{
		CountryContainers.registerContainer(this);
	}
}
