package engine.science;

import engine.people.AbstractPerson;

import java.util.ArrayList;

/**
 * Created by bob on 5/19/2016.
 */
public class HumanGenomeSequencing extends Discovery {


	protected HumanGenomeSequencing(ArrayList<Discovery> required) {
		super(required);
	}

	@Override
	public void postDiscovery() {
		AbstractPerson.healthInitial += 0.2;
		AbstractPerson.resistanceInitial += 0.1;
	}
}
