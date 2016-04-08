package engine.planets;


import java.util.ArrayList;

/**
 * Created by bob on 4/5/2016.
 *
 */
public class CountryContainers
{
	private static ArrayList<CountryContainer> containers = new ArrayList<>();
	public static void registerContainer(CountryContainer in)
	{
		containers.add(in);
	}
	public static void remove(Country in)
	{
		for(CountryContainer container :containers)
		{
			container.remove(in);
		}
	}
}
