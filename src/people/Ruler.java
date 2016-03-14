package people;
import cities.AbstractPerson;
import universe.UniversalConstants;
import planets.Country;
/*
    one ruler per country
*/
public class Ruler extends AbstractPerson
{
    public Ruler(Country parentCountry)
    {
        // assert that thtere is no ruler already//do it later
        double corruptionFactor = UniversalConstants.getCorruptionFactor(parentCountry);
        population = 1;
        foodUsePerPerson = UniversalConstants.foodUsePerRuler;
        crimeRisk = 0.0;//can be increased later
        crimeImpact = 10.0*UniversalConstants.importantPersonCrimeImpact;
        productivity = Double.NaN;//question mark
        wealth = corruptionFactor*UniversalConstants.defualtPersonStartWealth;//depends on gevernment type
        currentCity = parentCountry.getCapitalCity();
        home = parentCountry.getCapitalCity().getCapitalBuilding();
        type = AbstractPerson.Type.Ruler;
    }
}