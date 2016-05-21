











package engine.planets.hazards;

import engine.planets.Grid;

import java.io.Serializable;

public abstract class NaturalHazard implements Serializable
{
	protected NaturalHazard(Type type,Grid parentGrid) {
		this.type = type;
		affectedGrid = parentGrid;
	}

	public enum Type
    {
		Volcano,
	    Weather,
	    Disease,//disease other than standard person health decrease.
		Drought,
	    Earthquake
    }
	public final Type type; //necessary for random construction purposes
    private Grid affectedGrid;
    public abstract void ApplyToGrids();//possibly requires more args
}