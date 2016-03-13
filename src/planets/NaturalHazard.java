package planets;

import java.util.ArrayList;
import universe.UniqueId;

public abstract class NaturalHazard extends UniqueId
{
    private ArrayList<Grid> memberGrids;
    public abstract ApplyToGrids();//possibly requires more args
}