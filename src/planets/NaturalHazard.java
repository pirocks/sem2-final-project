











package planets;

import trash.UniqueId;

import java.util.ArrayList;

public abstract class NaturalHazard extends UniqueId
{
    private ArrayList<Grid> memberGrids;
    public abstract void ApplyToGrids();//possibly requires more args
}