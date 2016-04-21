package engine.planets.hazards;

import engine.planets.Grid;

/**
 * Created by bob on 4/11/2016.
 */
public class Volcano extends NaturalHazard {
	protected Volcano(Grid parentGrid) {
		super(Type.Volcano, parentGrid);
	}

	@Override
	public void ApplyToGrids() {
		// TODO: 4/11/2016
	}
}
