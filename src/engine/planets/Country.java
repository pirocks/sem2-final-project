package engine.planets;
/**
 * Created by bob on 3/5/2016.
 *
 *
 */

import engine.cities.City;
import engine.cities.CityContainer;
import engine.people.AbstractPerson;
import engine.people.PersonContainer;
import engine.universe.MoneySource;

import java.util.ArrayList;

public class Country extends MoneySource implements PersonContainer,CountryContainer, CityContainer,RoadContainer
{
    public static String[] CountryNames = 
    {};
    public static int countryNameCount;
    private ArrayList<Grid> grids;
    private String name;
    private ArrayList<Country> allies;
    private ArrayList<Country> atWarWith;
    private ArrayList<AbstractPerson> people;
    public ArrayList<Road> roads;
    private City capitalCity;

    @Override
    public void remove(City city) {
        if(city == capitalCity)
        {
	        capitalCity = null;
	        assert(false);
	        //TODO: new capital city
	        //TODO: if ruler dies
        }
    }

    @Override
    public void remove(AbstractPerson person) {

    }

    @Override
    public void remove(Country country) {

    }

    @Override
    public void remove(Road road) {

    }

    // private //capital city whitehhouse
    public static enum GovernmentType
    {
        Democracy,Communist,Fascist,Totalitarian
    }
    private GovernmentType governmentType;
    public Country(double wealth,ArrayList<Grid> grids,String name)
    {
        super(wealth);
        allies = new ArrayList<>();
        atWarWith = new ArrayList<>();
    }
    public ArrayList<NaturalHazard> getNaturalHazards()
    {
        ArrayList<NaturalHazard> out = new ArrayList<NaturalHazard>();
        for(Grid grid:grids)
        {
            ArrayList<NaturalHazard> hazards = grid.getHazards();
            for(NaturalHazard hazard:hazards)
                out.add(hazard);
        }
        return out;
    }
    public ArrayList<NaturalResource> getNaturalResourcess()
    {
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
    public void addRoad(Road road)
    {
        roads.add(road);
    }
    public ArrayList<Road> accsisbleRoads(City c)//I can't spell
    {
        ArrayList<Road> out = new ArrayList<>();
        for(Road road: roads)
        {
            if(road.passesThrough(c))
                out.add(road);
        }
        return out;
    }
    public void loosePerson(AbstractPerson person)
    {
        people.remove(person);
    }
}
