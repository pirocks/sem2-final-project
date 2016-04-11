package engine.planets.hazards;

import engine.planets.Grid;

/**
 * Created by bob on 4/11/2016.
 */
public class Weather extends NaturalHazard {
	protected Weather(Grid parentGrid) {
		super(Type.Weather, parentGrid);
	}

	@Override
	public void ApplyToGrids() {
		// TODO: 4/11/2016
	}
}
