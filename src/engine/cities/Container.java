package engine.cities;

import engine.tools.vehicles.Liver;
import engine.tools.weapons.Attackable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

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
	static void deregisterContainerInternal(Container container, Attackable object) {
		if(cityContainers.get(object).remove(container))
			deregisterContainerInternal(container,object);
	}

	HashMap<Attackable,Set<Container>> cityContainers= new HashMap<>();

	static void registerContainerInternal(Container typeContainer, Attackable object) {
		if(cityContainers.containsKey(object))
			cityContainers.get(object).add(typeContainer);
		else
			cityContainers.put(object,new HashSet<Container>(){{add(typeContainer);}});
	}
	static void kill(Attackable target) {
//		Killer.kill(target);
		Set<Container> toRemove = cityContainers.get(target);
		if(toRemove.size() == 0) {
			cityContainers.remove(target);
			return;
		}
		if(toRemove ==  null)
			System.out.print("vugjhbj");
		Set<Container> workingCopy  = new HashSet<>(toRemove);
		for (Container container : workingCopy) {
			container.remove(target);
		}
		cityContainers.get(target).removeAll(workingCopy);
		if(target instanceof Liver)
			Liver.livers.remove(target);
		kill(target);

	}
	static void kill(ArrayList<? extends Attackable> targets) {
		for (Attackable target : targets) {
			kill(target);
		}

	}
}
