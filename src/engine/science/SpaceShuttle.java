package engine.science;

import engine.tools.vehicles.space.shuttle.Shuttle;

import java.util.ArrayList;

/**
 * Created by bob on 5/19/2016.
 */
public class SpaceShuttle extends Discovery {

	protected SpaceShuttle(ArrayList<Discovery> required) {
		super(required);
	}

	@Override
	public void postDiscovery() {
		Shuttle.maxPassengersMult *= 2;
		Shuttle.startHealthMult *= 2;
		Shuttle.maxWeightMult *= 2;
	}
}
