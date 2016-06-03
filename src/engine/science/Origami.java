package engine.science;

import java.util.ArrayList;

/**
 * Created by bob on 5/19/2016.
 */
public class Origami extends Discovery{
	protected Origami(ArrayList<Discovery> required) {
		super(required);
	}

	@Override
	public void postDiscovery() {
		// doesn't do anything
	}
}
