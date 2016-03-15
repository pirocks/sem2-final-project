package universe;

import java.util.ArrayList;

public abstract class UniqueId//this entire class is probably uneeded thanks to serializable
{
    private static ArrayList<UniqueId> items = new ArrayList<>();
    private static int idCounter = 0;
    private final int id;
    public int getId()
    {
        return id;
    };
    public UniqueId()
    {
        id = idCounter;
        items.add(this);
        idCounter++;
    }
}