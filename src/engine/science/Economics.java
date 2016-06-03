package engine.science;

import engine.people.cityworkers.Bureaucrat;

import java.util.ArrayList;

/**
 * Created by bob on 5/19/2016.
 */
public class Economics extends Discovery {

	protected Economics(ArrayList<Discovery> required) {
		super(required);
	}

	@Override
	public void postDiscovery() {
		Bureaucrat.crimeRiskInitial /=  2;
		Bureaucrat.crimeImpactInitial /= 2;
		Bureaucrat.foodUsePerPersonInitial /= 2;
	}
}
