package engine.people.cityworkers;

import engine.buildings.Building;
import engine.cities.City;
import engine.universe.Country;

/**
 * Created by bob on 4/10/2016.
 *
 */
public class PeopleInitialConstants
{
	public int population;
	public double foodUsePerPerson;
	public double crimeRisk;
	public double crimeImpact;
	public double salary;
	public Country country;
	public PeopleInitialConstants(int population,double foodUsePerPerson,
	                              double crimeRisk,double crimeImpact,
	                              double salary,Country country){
		this.population = population;
		this.foodUsePerPerson = foodUsePerPerson;
		this.crimeRisk = crimeRisk;
		this.crimeImpact = crimeImpact;
		this.salary = salary;
		this.country = country;
	}
}
