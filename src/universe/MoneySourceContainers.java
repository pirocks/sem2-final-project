package universe;

import java.util.ArrayList;

/**
 * Created by bob on 4/6/2016.
 *
 */
public class MoneySourceContainers
{
	private ArrayList<MoneySourceContainer> containers = new ArrayList<>();
	public void registerContainer(MoneySourceContainer c){containers.add(c);}
	public void remove(MoneySource moneySource)
	{
		for(MoneySourceContainer container :containers)
			container.remove(moneySource);
	}
}
