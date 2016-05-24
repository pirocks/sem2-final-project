package engine.cities;

import engine.tools.weapons.Attackable;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by bob on 4/4/2016.
 * for destruction of engine.cities
 */
public interface Container
{
	void remove(Attackable attackable);
	default void registerContainer(ArrayList<Attackable> containedObjects)
	{
		for (Attackable object : containedObjects) {
			registerContainer(this,object);
		}
	}
	HashMap<Attackable,ArrayList<Container>> cityContainers= new HashMap<>();

	static void registerContainer(Container typeContainer, Attackable object) {
		if(cityContainers.containsKey(object))
			cityContainers.get(object).add(typeContainer);
		else
			cityContainers.put(object,new ArrayList<Container>(){{add(typeContainer);}});
	}
	static void kill(Attackable target)
	{
		for (Container container : cityContainers.get(target)) {
			container.remove(target);
		}
		cityContainers.remove(target);

	}

}
