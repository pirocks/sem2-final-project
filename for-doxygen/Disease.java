package engine.planets.hazards;

import engine.planets.Grid;

/**
 * Created by bob on 4/11/2016.
 */
public class Disease extends NaturalHazard {
	protected Disease(Grid parentGrid) {
		super(Type.Disease, parentGrid);
	}

	@Override
	public void ApplyToGrids() {
		// TODO: 4/11/2016
	}
}
