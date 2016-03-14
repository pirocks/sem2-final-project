package universe;

import java.util.ArrayList;

public abstract class UniqueId
{
    private ArrayList<UniqueId> items = new ArrayList<>();
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
    public abstract String toSaveString();
    public abstract void loadFromSaveString(String in);
}