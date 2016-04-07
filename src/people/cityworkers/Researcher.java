package people.cityworkers;

import buildings.housing.Housing;
import buildings.workplaces.ResearchArea;
import cities.City;
import people.AbstractPerson;
public class Researcher extends CityWorker
{
    private ResearchArea workplace;
    public Researcher(City parentCity, Housing home)
    {
		super(AbstractPerson.Type.Researcher,parentCity,home);
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
        //TODO:implement
    }
}