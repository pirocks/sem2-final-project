package ai.mayor;

import engine.cities.City;
import engine.people.cityworkers.Bureaucrat;

import java.io.Serializable;

/**
 * Created by user on 4/13/2016.
 */
public class AiMayor extends Bureaucrat implements Serializable {
	public AiMayor(City parentCity) {
		super(parentCity);
	}
}
