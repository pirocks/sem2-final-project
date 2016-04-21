package engine.planets.hazards;

import engine.planets.Grid;

/**
 * Created by bob on 4/11/2016.
 * todo wtf ois going on with food.
 */
public class Drought extends NaturalHazard{
	protected Drought(Grid parentGrid) {
		super(Type.Drought, parentGrid);
	}

	@Override
	public void ApplyToGrids() {
		// TODO: 4/11/2016
	}
}
