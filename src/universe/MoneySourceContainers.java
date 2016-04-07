package universe;

import java.util.ArrayList;

/**
 * Created by bob on 4/6/2016.
 *
 */
public class MoneySourceContainers
{
	private static ArrayList<MoneySourceContainer> containers = new ArrayList<>();
	public static void registerContainer(MoneySourceContainer c){containers.add(c);}
	public static void remove(MoneySource moneySource)
	{
		for(MoneySourceContainer container :containers)
			container.remove(moneySource);
	}
}
