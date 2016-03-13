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
        double corruptionFactor;
        switch(parentCountry.getGovermentType())
        {
            case Democracy:
               corruptionFactor = UniversalConstants.corruptionFactorInDemocracy;
               break;
            case Communist:
                corruptionFactor = UniversalConstants.corruptionFactorInCommunist;
                break;
            case Fascist:
                corruptionFactor = UniversalConstants.corruptionFactorInFascist;
            case Totalitarian:
                corruptionFactor = UniversalConstants.corruptionFactorInTotalitarian;
                break;
            default:
                assert(false);
                corruptionFactor = NaN;
        }
        population = 1;
        foodUsePerPerson = UniversalConstants.foodUsePerRuler;
        crimeRisk = 0.0;//can be increased later
        crimeImpact = 10.0*UniversalConstants.importantPersonCrimeImpact;
        productivity = NaN;//question mark
        wealth = corruptionFactor*UniversalConstants.defualtPersonStartWealth;//depends on gevernment type
        currentCity = parentCountry.getCapitalCity();
        home = parentCountry.getCapitalCity();
        type = AbstractPerson.Type.Ruler;
    }
}