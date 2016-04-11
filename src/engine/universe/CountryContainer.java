package engine.universe;

/**
 * Created by bob on 4/5/2016.
 *
 */
public interface CountryContainer {
	void remove(Country country, Country conqueror);
	default void registerCountryContainer()
	{
		CountryContainers.registerContainer(this);
	}
}
