public class UniqueId
{
    private static int idCounter = 0;
    private final int id;
    public getId()
    {
        return id;
    };
    public UniqueId()
    {
        id = idCounter;
        idCounter++;
    }
}