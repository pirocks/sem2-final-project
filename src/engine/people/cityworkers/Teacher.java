package engine.people.cityworkers;

import engine.buildings.workplaces.School;
import engine.buildings.workplaces.Workplace;
import engine.cities.City;
import engine.people.AbstractPerson;
import engine.planets.LocationPlanet;
import engine.universe.UniversalConstants;

import java.util.ArrayList;

public class Teacher<Type extends AbstractPerson> extends CityWorker implements Cloneable
{
    public double progress = 0.0;//from 0 to 1

    public Teacher(Teacher<Type> typeTeacher) {
        super(typeTeacher);
        //two teachers cannot work on same student
	    //in the conext of this cnstructor studdent i most likely nullanyway
	    student = null;
	    workplace = typeTeacher.getWorkBuilding();
	    progress = 0;
	    registerContainer(workplace);// TODO: 5/29/2016 implment more
    }

    public Type getStudent() {
        return student;
    }

    private Type student;
    public School workplace;

    public static int populationInitial = 250;
    public static double foodUsePerPersonInitial = UniversalConstants.normalFoodUsePerPerson;
    public static double crimeRiskInitial = UniversalConstants.normalCrimeRisk;
    public static double crimeImpactInitial = UniversalConstants.normalPersonCrimeImpact;
    public static double salaryInitial = UniversalConstants.normalPersonSalary;

    public Teacher(City parentCity,LocationPlanet location) {
        super(new PeopleInitialConstants(populationInitial,
                foodUsePerPersonInitial,
                crimeRiskInitial,
                crimeImpactInitial,
                salaryInitial,
                parentCity.getParentCountry(),location),parentCity);
    }

    @Override
    protected void setWorkplace(Workplace workplace) {
	    if(this.workplace != null)
		    deregisterContainer(this.workplace);
        this.workplace = (School) workplace;
	    registerContainer(workplace);
    }

    public School getWorkBuilding() {
        return workplace;
    }

    @Override
    public void setWorkPlaceToNull() {
        deregisterContainer(workplace);
        workplace = null;
    }

    public void doSkill(double time) {
        progress += population*time/(AbstractPerson.timeToTrain*student.getPopulation());
	    if(progress > 1.0)
		    studentCompletedHandler(student);
    }

	private void studentCompletedHandler(Type student) {
		// TODO: 5/29/2016
	}

	@Override
    protected CityWorker splitInternal() {
        return new Teacher<>(this);
    }

    @Override
    public ArrayList<LocationPlanet> getLocationPlanet() {
        return null;// TODO: 4/9/2016
    }

}