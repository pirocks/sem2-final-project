package engine.science;

import engine.tools.vehicles.space.shuttle.ShuttleSmall;

import java.util.ArrayList;

/**
 * Created by bob on 5/19/2016.
 */
public class SolidRocketBoosters extends Discovery {


	protected SolidRocketBoosters(ArrayList<Discovery> required) {
		super(required);
	}

	@Override
	public void postDiscovery() {
		ShuttleSmall.startHealthMult *= 1.2;
	}
}
