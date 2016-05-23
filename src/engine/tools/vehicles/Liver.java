package engine.tools.vehicles;

import java.util.ArrayList;

/**
 * Created by bob on 5/22/2016.
 */
public interface Liver {
	ArrayList<Liver> livers = new ArrayList<>();
	void doLife(long time);
	default void registerLiver()
	{
		Liver.register(this);
	}
	static void register(Liver liver){
		livers.add(liver);
	}
	static void doLifeAll(long time) {
		for (Liver liver : livers) {
			liver.doLife(time);
		}

	}
}
