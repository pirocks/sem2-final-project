package engine.science;

import engine.tools.vehicles.space.SpaceCraft;

import java.util.ArrayList;

/**
 * Created by bob on 5/19/2016.
 */
public class MolecularCircuits extends Discovery {

	protected MolecularCircuits(ArrayList<Discovery> required) {
		super(required);
	}

	@Override
	public void postDiscovery() {
		SpaceCraft.startHealthMult *= 1.1;
	}
}
