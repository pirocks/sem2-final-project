














package people;


import cities.AbstractPerson;
import cities.Building;
import cities.City;


public abstract class CityWorker extends AbstractPerson
{
	private Building home;
    private City currentCity;//should be renamed to parent city
	public abstract void goHome();
	public abstract void goToWork();
	public CityWorker(AbstractPerson.Type type,City city,Building home)
	{
		super(type,city.getParentCountry());
		this.home = home;
		currentCity = city;
	}
}