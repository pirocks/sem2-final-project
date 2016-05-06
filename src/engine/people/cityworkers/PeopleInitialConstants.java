package engine.people.cityworkers;

import engine.buildings.Building;
import engine.cities.City;
import engine.planets.LocationPlanet;
import engine.universe.Country;

import java.io.Serializable;

/**
 * Created by bob on 4/10/2016.
 *
 */
public class PeopleInitialConstants implements Serializable
{
	public int population;
	public double foodUsePerPerson;
	public double crimeRisk;
	public double crimeImpact;
	public double salary;
	public Country country;
	public LocationPlanet location;

	public PeopleInitialConstants(int population,double foodUsePerPerson,
	                              double crimeRisk,double crimeImpact,
	                              double salary,Country country,LocationPlanet location){
		this.population = population;
		this.foodUsePerPerson = foodUsePerPerson;
		this.crimeRisk = crimeRisk;
		this.crimeImpact = crimeImpact;
		this.salary = salary;
		this.country = country;
		this.location = location;
	}
}
