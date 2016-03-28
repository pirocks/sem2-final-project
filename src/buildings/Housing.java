public class Housing extends Building
{
    private int maximumOccupancy;
    protected ArrayList<CityWorker> residents;
    public Housing(Type type,ArrayList<CityWorker> residents,CityBlock parentBlock)
    {
    	super(type,parentBlock,true);
    	this.residents = residents;
    	switch(type)
    	{
    		case ApartmentBlock:
    			maximumOccupancy = ApartmentBlock.maximumOccupancyInitial;
    			break;
    		case RulersHouse:
    			maximumOccupancy = RulersHouse.maximumOccupancyInitial;
    			break;
    		case WealthWorkersHouseBlock:
    			maximumOccupancy = WealthWorkersHouseBlock.maximumOccupancyInitial;
    			break;
    		case WorkersHouseBlock:
    			maximumOccupancy = WorkersHouseBlock.maximumOccupancyInitial;
    			break;
    		default:
    			assert(false);
    			break;
    	}
    }
    public boolean overcrowdedQ()
    {
        int sum = getPopulation();
        if(sum > maximumOccupancy)
            return false;
        return true;
    }
    public int getPopulation()
    {
        int sum = 0;
        for(CityWorker person:residents)
            sum += person.getPopulation();
        return sum;
    }

}