package people;
import cities.AbstractPerson;
import universe.UniversalConstants;
import planets.Country;
import cities.City;
import cities.Building;
public class Researcher extends AbstractPerson
{
    public Researcher(Country parentCountry, City parentCity, Building home)
    {
        double corruptionFactor = UniversalConstants.getCorruptionFactor(parentCountry);
        population = 100;
        foodUsePerPerson = 1.5*UniversalConstants.normalFoodUsePerPerson;
        crimeRisk = 0.0000000001*corruptionFactor;//another magic constant should be smaller than average worker
        crimeImpact = 0.5*UniversalConstants.importantPersonCrimeImpact;
        wealth = 1.5*UniversalConstants.defualtPersonStartWealth;
        currentCity = parentCity;
        this.home = home;
        type = AbstractPerson.Type.Researcher;
    }
    
}