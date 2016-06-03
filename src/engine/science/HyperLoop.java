package engine.science;

import engine.tools.vehicles.roadgoing.AllPurpose;
import engine.tools.vehicles.roadgoing.Train;

import java.util.ArrayList;

/**
 * Created by bob on 5/19/2016.
 */
public class HyperLoop extends Discovery{
	protected HyperLoop(ArrayList<Discovery> required) {
		super(required);
	}

	@Override
	public void postDiscovery() {
		AllPurpose.maxPassengersInitial += 10;
		Train.maxPassengersInitial  += 10;
		Train.maxWeightInitial *=  1.1;
	}
}
