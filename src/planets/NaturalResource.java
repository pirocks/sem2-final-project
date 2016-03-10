package universe;







abstract class NaturalResource extends UniqueId
{
    public enum Type
    {
        Iron,Oil,Uranium,Helium,Food,Water,Sunlight,
    }
    public final Type type;
    private double quantity;//don't forget to check for overflow with sun
    private double restoreRate;//0 if not applicable to type
    public abstract NaturalResource(NaturalResource.Type in,double quantity, double restoreRate)
    
}