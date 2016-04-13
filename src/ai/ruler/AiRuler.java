package ai.ruler;

import engine.cities.City;
import engine.people.cityworkers.Ruler;

import java.io.Serializable;

/**
 * Created by user on 4/13/2016.
 */
public class AiRuler extends Ruler implements Serializable{
	public AiRuler(City parentCity) {
		super(parentCity);
	}
}
