package engine.planets.hazards;

import engine.planets.Grid;

/**
 * Created by bob on 5/10/2016.
 */
public class Earthquake extends NaturalHazard {
	public Earthquake(Grid parentGrid) {
		super(Type.Earthquake, parentGrid);
	}

	@Override
	public void ApplyToGrids() {
		// TODO: 5/10/2016
	}
}
