package people.cityworkers;

import buildings.Building;
import buildings.workplaces.ResearchArea;
import cities.City;
import people.AbstractPerson;
public class Researcher extends AbstractPerson
{
    private ResearchArea workplace;
    public Researcher(City parentCity, Building home)
    {
		super(AbstractPerson.Type.Researcher,parentCity,home);
    }
    public ResearchArea getWorkBuilding()
    {
        return workplace;
    }

    @Override
    public void doSkill(long time) {

    }
}