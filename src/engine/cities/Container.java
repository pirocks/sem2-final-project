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
	default void registerContainer(ArrayList<? extends Attackable> containedObjects) {
		for (Attackable object : containedObjects) {
			registerContainerInternal(this,object);
		}
	}
	default void registerContainer(Attackable attackable)
	{
		registerContainerInternal(this,attackable);
	}
	default void deregisterContainer(Attackable object)
	{
		deregisterContainerInternal(this,object);
	}

	static void deregisterContainerInternal(Container container, Attackable object)
	{
		if(cityContainers.get(object).remove(container))
			deregisterContainerInternal(container,object);
	}

	HashMap<Attackable,ArrayList<Container>> cityContainers= new HashMap<>();

	static void registerContainerInternal(Container typeContainer, Attackable object) {
		if(cityContainers.containsKey(object))
			cityContainers.get(object).add(typeContainer);
		else
			cityContainers.put(object,new ArrayList<Container>(){{add(typeContainer);}});
	}
	static void kill(Attackable target) {
		ArrayList<Container> containers = null;
		containers = cityContainers.get(target);
		if(containers == null) {
			System.out.print("chgvj");
		}
		for (Container container : containers) {
			container.remove(target);
		}
		cityContainers.remove(target);
	}
	static void kill(ArrayList<? extends Attackable> targets)
	{
		for (Attackable target : targets) {
			kill(target);
		}

	}

}
