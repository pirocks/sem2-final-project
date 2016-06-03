package engine.science;

import engine.tools.vehicles.space.shuttle.Shuttle;

import java.util.ArrayList;

/**
 * Created by bob on 5/19/2016.
 */
public class SpaceLivingOne extends Discovery {
	protected SpaceLivingOne(ArrayList<Discovery> required) {
		super(required);
	}

	@Override
	public void postDiscovery() {
		Shuttle.maxPassengersMult *= 1.1;
	}
}
