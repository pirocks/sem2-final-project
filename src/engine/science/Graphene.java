package engine.science;

import engine.tools.vehicles.air.Aircraft;
import engine.tools.vehicles.land.AutomatedArmouredVehicle;
import engine.tools.vehicles.roadgoing.AllPurpose;
import engine.tools.vehicles.space.SpaceCraft;

import java.util.ArrayList;

/**
 * Created by bob on 5/19/2016.
 */
public class Graphene extends Discovery {

	protected Graphene(ArrayList<Discovery> required) {
		super(required);
	}

	@Override
	public void postDiscovery() {
		Aircraft.startHealthAdd += 100;
		AllPurpose.startHealthInitial += 100;
		AutomatedArmouredVehicle.startHealthInitial += 100;
		SpaceCraft.startHealthMult = 1.1;
	}
}
