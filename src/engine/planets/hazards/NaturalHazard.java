











package engine.planets.hazards;

import engine.planets.Grid;

import java.util.ArrayList;

public abstract class NaturalHazard
{
	protected NaturalHazard(Type type,Grid parentGrid) {
		this.type = type;
		affectedGrid = parentGrid;
	}

	public static enum Type
    {
		Volcano,
	    Weather,
	    Disease,//disease other than standard person health decrease.
		Drought
    }
	public final Type type; //necessary for random construction purposes
    private Grid affectedGrid;
    public abstract void ApplyToGrids();//possibly requires more args
}