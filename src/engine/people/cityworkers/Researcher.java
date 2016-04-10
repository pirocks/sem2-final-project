package engine.people.cityworkers;

import engine.buildings.housing.Housing;
import engine.buildings.workplaces.ResearchArea;
import engine.cities.City;
import engine.people.AbstractPerson;
public class Researcher extends CityWorker
{
    private ResearchArea workplace;
    public Researcher(City parentCity, Housing home)
    {
		super(parentCity,home);
    }
    public ResearchArea getWorkBuilding()
    {
        return workplace;
    }

    @Override
    public void setWorkPlaceToNull() {
        workplace = null;
    }

    @Override
    public void doSkill(long time) {
        //TODO:implemented
    }

    @Override
    public double getWeight() {
        return 0;// TODO: 4/9/2016
    }
}