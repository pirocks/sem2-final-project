



















package planets;


import universe.*;




public class NaturalResource
{
    Resource resource;
    private double restoreRate;//0 if not applicable to type
    private double max;
    public NaturalResource(Resource.Type in,double quantity, double restoreRate,double max)
    {
        super(value);
        type = in;
        this.restoreRate = restoreRate;
        this.max = max;
        resource = new Resource(in,quantity);
    };
    
}