package people;
import cities.AbstractPerson;
import universe.UniversalConstants;
import planets.Country;
import cities.Building;
import cities.City;
public class Worker extends AbstractPerson
{
    public Worker(Country parentCountry,City parentCity,Building home)
    {
        double corruptionFactor = UniversalConstants.getCorruptionFactor(parentCountry);
        population = 1000;//magic number move to universal constants later
        foodUsePerPerson = UniversalConstants.normalFoodUsePerPerson;
        crimeRisk = 0.00000001*corruptionFactor;//small number times corruption factor move to Universalcontants
        wealth = UniversalConstants.defualtPersonStartWealth;
        currentCity = parentCity;
        this.home = home;
        type = Type.Worker;
    }
}