package universe;







class NaturalResource
{
    public enum Type
    {
        Iron,Oil,Uranium,Helium,Food
    }
    public final Type type;
    private double quantity;
    private double restoreRate;//0 if not applicable to type
    public NaturalResource(NaturalResource.Type in,)
    {
        type = in;
        

    }
    public NaturalResource()
    {
        
    }
    
}