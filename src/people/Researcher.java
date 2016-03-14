package people;
import cities.AbstractPerson;
import universe.UniversalConstants;
import planets.Country;
public class Researcher extends AbstractPerson
{
    public Researcher(Country parentCountry, City parentCity)
    {
        double corruptionFactor = Universalcontants.getCorruptionFactor();
        population = 100;
        foodUsePerPerson = 1.5*UniversalConstants.foodUsePerPerson;
        crimeRisk = 0.0000000001*corruptionFactor;//another magic constant should be smaller than average worker
        crimeImpact = 0.5*UniversalConstants.importantPersonCrimeImpact
        wealth = 1.5* UniversalConstants.
        currentCity = parentCity;
        
    }
    
}