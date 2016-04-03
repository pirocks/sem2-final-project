package planets;


import universe.MoneySource;
import universe.Resource;




public class NaturalResource extends MoneySource
{
    Resource resource;
    private double restoreRate;//0 if not applicable to type
    private double max;
    public NaturalResource(Resource.Type in,double quantity, double restoreRate,double max)
    {
        super(Double.NaN);
        this.restoreRate = restoreRate;
        this.max = max;
        resource = new Resource(in,quantity);
    };
    
}