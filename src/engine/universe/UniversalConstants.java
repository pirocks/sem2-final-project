package engine.universe;

import java.math.BigDecimal;

public class UniversalConstants
{
    //most of these should be moved to absract person
    public static final double normalCrimeRisk = 1.0;//these nubers ared much to high. need to do math to fid what size they should be
    public static final double normalPersonSalary = 100;
    public static final double normalFoodUsePerPerson = 1.0;
    public static final double foodUsePerRuler = 3*normalFoodUsePerPerson;
    public static final double importantPersonCrimeImpact = 100.0; 
    public static final double normalPersonCrimeImpact = 1.0;
    
    public static final double defualtPersonStartWealth = 100.0;
    public static final double corruptionFactorInCommunist  = 1.0;
    public static final double corruptionFactorInDemocracy  = .5;
    public static final double corruptionFactorInFascist = 2.0;
    public static final double corruptionFactorInTotalitarian = 10.0;
    public static double getCorruptionFactor(Country parentCountry)
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
                corruptionFactor = Double.NaN;
        }
        return corruptionFactor;
    }


    //actually universal
	private static double bigDecimalConversionFactorAsDouble;
	public static BigDecimal bigDecimalConversionFactor = new BigDecimal(bigDecimalConversionFactorAsDouble);
}
