package engine.people.cityworkers;

import engine.buildings.housing.Housing;
import engine.buildings.workplaces.School;
import engine.cities.City;
import engine.people.AbstractPerson;
import engine.planets.LocationPlanet;
import engine.universe.Country;
import engine.universe.UniversalConstants;

public class Teacher<Type extends AbstractPerson> extends CityWorker {
    public double progress = 0.0;//from 0 to 1
    private Type student;
    public School workplace;

    public static int populationInitial = 250;
    public static double foodUsePerPersonInitial = UniversalConstants.normalFoodUsePerPerson;
    public static double crimeRiskInitial = UniversalConstants.normalCrimeRisk;
    public static double crimeImpactInitial = UniversalConstants.normalPersonCrimeImpact;
    public static double salaryInitial = UniversalConstants.normalPersonSalary;

    public Teacher(City parentCity) {
        super(new PeopleInitialConstants(populationInitial,
                foodUsePerPersonInitial,
                crimeRiskInitial,
                crimeImpactInitial,
                salaryInitial,
                parentCity.getParentCountry()),parentCity);
    }

    public School getWorkBuilding() {
        return workplace;
    }

    @Override
    public void setWorkPlaceToNull() {
        workplace = null;
    }

    public void doSkill(long time) {
        //TODO:unimplmented
    }

    @Override
    public double getWeight() {
        return 0;// TODO: 4/9/2016  people have weight for vehicles
    }

    @Override
    public LocationPlanet getLocationPlanet() {
        return null;// TODO: 4/9/2016
    }

}