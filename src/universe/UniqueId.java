package universe;

import java.util.ArrayList;

public class UniqueId
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
}