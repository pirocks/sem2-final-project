package engine.tools;

import engine.cities.Container;
import engine.tools.vehicles.Liver;
import engine.tools.weapons.Attackable;

import java.util.HashSet;
import java.util.Set;


/**
 * Created by bob on 5/29/2016.
 */
public class Killer {
	public static boolean safeToKill = true;
	public static Set<Attackable> toBeKilled = new HashSet<>();
	public static void kill(Attackable target) {
		if (safeToKill) {
			safeToKill = false;
			Set<Container> containers = Container.cityContainers.get(target);
			if(!target.amIDead) {
				if (containers == null) {
					System.out.print("chgvj");
				}
				for (Container container : containers) {
					container.remove(target);
				}
				Liver.livers.remove(target);//despite what intelij may think this is not "suspicious" and does not merit a compiler warning
				Set<Attackable> toBeKilledWorkingCopy = new HashSet<Attackable>(toBeKilled);
				for (Attackable attackable : toBeKilledWorkingCopy) {
					safeToKill = true;
					kill(attackable);
				}
				safeToKill = false;
				toBeKilled.removeAll(toBeKilledWorkingCopy);
				safeToKill = true;
			}
			else
				System.out.print("you shouldn't see this but its not that bad. Just a memory leak:" + target);
		}
		else {
			toBeKilled.add(target);
		}
		Container.cityContainers.remove(target);
	}

	public static void reKill() {
		Set<Attackable> toBeKilledWorkingCopy = new HashSet<Attackable>(toBeKilled);
		for (Attackable attackable : toBeKilledWorkingCopy) {
			safeToKill = true;
			kill(attackable);
		}
		safeToKill = false;
		toBeKilled.removeAll(toBeKilledWorkingCopy);
		safeToKill = true;
	}
}
