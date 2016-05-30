package ai.mayor;

import engine.cities.City;
import engine.people.cityworkers.Bureaucrat;
import engine.tools.vehicles.Liver;

import java.io.Serializable;

/**
 * Created by user on 4/13/2016.
 *
 */
public class AiMayor extends Bureaucrat implements Serializable,Liver {
	public AiMayor(City parentCity) {
		super(parentCity,null);
		registerLiver();
	}
}
