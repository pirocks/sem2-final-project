package engine.universe;
/**
 * Created by bob on 3/5/2016.
 *
 *
 */

import engine.cities.City;
import engine.cities.Container;
import engine.people.AbstractPerson;
import engine.planets.Grid;
import engine.planets.NaturalResource;
import engine.science.CountriesDiscoveries;
import engine.tools.vehicles.CityBuilder;
import engine.tools.weapons.Attackable;

import java.io.Serializable;
import java.util.ArrayList;

public class Country extends MoneySource implements Serializable, Container
{
	private static String[] CountryNames =
    {"England","USA","France","China","Tanzania","Botswana",
        "Seychelles","Scotland","Liechtenstein","Comoros","Tuvalu","Kosovo","Sahrawi"
    };
	private static int countryNameCount = 0;
	private ArrayList<Grid> grids;
	private ArrayList<Country> allies;
	private ArrayList<Country> atWarWith;
	private ArrayList<AbstractPerson> people;
	private CountriesDiscoveries countriesDiscoveries;
	private City capitalCity;
	public CityBuilder initialBuilder;
    public Country(UniverseConstructionContext u) {
        super(Double.NaN);
        try {
	        name = CountryNames[countryNameCount];
        }
        catch (Exception e)
        {
	        name = "country" + countryNameCount;
        }
	    countryNameCount++;
	    allies = new ArrayList<>();
	    atWarWith = new ArrayList<>();
	    grids = new ArrayList<>();
	    people = new ArrayList<>();
	    countriesDiscoveries = new CountriesDiscoveries(this);
    }
    private void remove(City city) {
        if(city == capitalCity)
        {
	        capitalCity = null;
	        assert(false);
	        //TODO: new capital city
	        //TODO: if ruler dies
        }
    }
    private void remove(AbstractPerson person) {
        if(people.remove(person))
	        remove(person);
    }
	public String getName() {
		return name;
	}
	public ArrayList<Country> getAllies() {
		return allies;
	}
	public ArrayList<Country> getAtWarWith() {
		return atWarWith;
	}
	public void setCapitalCity(City capitalCity) {
		if(this.capitalCity != null){
			deregisterContainer(this.capitalCity);
		}
		this.capitalCity = capitalCity;
		registerContainer(capitalCity);
	}

	@Override
	public void remove(Attackable attackable) {
		if(attackable instanceof City){
			remove((City)attackable);
		}
		else if(attackable instanceof AbstractPerson){
			remove((AbstractPerson) attackable);
		}
		else
			throw new IllegalStateException();
	}

	// private //capital city whitehhouse
    public enum GovernmentType {
        Democracy,Communist,Fascist,Totalitarian
    }
	private GovernmentType governmentType;
	public ArrayList<NaturalResource> getNaturalResources() {
        ArrayList<NaturalResource> out = new ArrayList<NaturalResource>();
        for(Grid grid:grids)
        {
            ArrayList<NaturalResource> naturalResources = grid.getNaturalResources();
            for(NaturalResource resource:naturalResources)
                out.add(resource);
        }
        return out;
    }
	public GovernmentType getGovermentType()
    {
        return governmentType;
    }
	public City getCapitalCity()
    {
        return capitalCity;
    }
	public ArrayList<City> getAllCities() {
		ArrayList<City> out = new ArrayList<>();
		for(Grid grid:grids)
		{
			out.addAll(grid.getCitys());
		}
		return out;
	}
	public void loosePerson(AbstractPerson person)
    {
        people.remove(person);
    }
	public ArrayList<AbstractPerson> getPeople() {
		return people;
	}
	private String name;
	public ArrayList<Grid> getGrids() {
		return grids;
	}
}
