package ai.ruler;

import engine.people.cityworkers.Ruler;
import engine.tools.vehicles.Liver;
import engine.universe.Country;

import java.io.Serializable;

/**
 * Created by user on 4/13/2016.
 *
 */
public class AiRuler extends Ruler implements Serializable,Liver {
	public AiRuler(Country parentCountry) {
		super(parentCountry,null);
		registerLiver();
	}

}
