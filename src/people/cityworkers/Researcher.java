

















package people.cityworkers;

import buildings.workplaces.ResearchArea;
import cities.AbstractPerson;
import cities.Building;
import cities.City;
public class Researcher extends AbstractPerson
{
    private ResearchArea workplace;
    public Researcher(City parentCity, Building home)
    {
		super(AbstractPerson.Type.Researcher,parentCity,home);
    }
    public ResearchArea getWorkBuilding() {
        return workplace;
    }

    @Override
    public void doSkill(long time) {

    }
}