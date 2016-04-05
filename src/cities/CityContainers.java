package cities;

import java.util.ArrayList;

/**
 * Created by bob on 4/5/2016.
 */
public class CityContainers
{
	private static ArrayList<CityContainer> containers = new ArrayList<CityContainer>();
	public static void registerContainer(CityContainer in)
	{
		containers.add(in);
	}
	public static void remove(City in)
	{
		for(CityContainer container:containers)
		{
			container.remove(in);
		}
	}
}
