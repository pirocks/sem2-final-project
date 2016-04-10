package engine.people.cityworkers;

import engine.buildings.Building;
import engine.cities.City;

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
	public City parentCity;
	public Building home;
	public PeopleInitialConstants(int population,double foodUsePerPerson,
	                              double crimeRisk,double crimeImpact,
	                              double salary,City parentCity,Building home){
		this.population = population;
		this.foodUsePerPerson = foodUsePerPerson;
		this.crimeRisk = crimeRisk;
		this.crimeImpact = crimeImpact;
		this.salary = salary;
		this.parentCity = parentCity;
		this.home = home;
	}
}
