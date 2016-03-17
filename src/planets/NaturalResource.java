package planets;


import universe.UniqueId;
import universe.MoneySource;




public class NaturalResource extends MoneySource//maybe???
{
    public enum Type
    {
        Iron,Oil,Uranium,Helium,Food,Water,Sunlight,
    }
    public final Type type;
    private double quantity;//don't forget to check for overflow with sun
    private double restoreRate;//0 if not applicable to type
    public NaturalResource(NaturalResource.Type in,double quantity, double restoreRate)
    {
        type = in;
        this.quantity = quantity;
        this.restoreRate = restoreRate;
    };
    
}