package engine.science;

import engine.tools.weapons.guns.Gun;

import java.util.ArrayList;

/**
 * Created by bob on 5/19/2016.
 */
public class LethalTasers extends Discovery {
	protected LethalTasers(ArrayList<Discovery> required) {
		super(required);
	}

	@Override
	public void postDiscovery() {
		Gun.damageMult = 1.2;
	}
}
