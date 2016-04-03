











package planets;

import java.util.ArrayList;

public abstract class NaturalHazard
{
    private ArrayList<Grid> memberGrids;
    public abstract void ApplyToGrids();//possibly requires more args
}