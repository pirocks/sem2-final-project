package people;
import cities.AbstractPerson;
import universe.UnivesalConstants;

/*
    one ruler per country
*/
public class Ruler
{
    public Ruler(Country parentCountry)
    {
        double corruptionFactor;
        switch(parentCountry.getGovermentType())
        {
            case Democracy:
               corruptionFactor = UnivesalConstants.corruptionFactorInDemocracy;
               break;
            case Communist:
                corruptionFactor = UnivesalConstants.corruptionFactorInCommunist;
                break;
            case Fascist:
                corruptionFactor = UnivesalConstants.corruptionFactorInFascist;
            case Totalitarian:
                corruptionFactor = UnivesalConstants.corruptionFactorInTotalitarian
            default:
                assert(false);
                corruptionFactor = NaN;
        }
        population = 1;
        foodUsePerPerson = UnivesalConstants.foodUsePerRuler;
        crimeRisk = 0.0;//can be increased later
        crimeImpact = 10.0*UnivesalConstants.importantPersonCrimeImpact;
        productivity = NaN;//question mark
        wealth = corruptionFactor*UnivesalConstants.defualtPersonStartWealth;//depends on gevernment type
        currentCity = parentCountry.getCapitalCity();
        home = 
    }
}