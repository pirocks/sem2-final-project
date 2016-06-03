package engine.people.cityworkers;

import engine.cities.City;
import engine.people.AbstractPerson;
import engine.planets.LocationPlanet;
import engine.universe.UniversalConstants;
import ui.requests.StudentCompletedAlert;

public class Teacher<Type extends AbstractPerson> extends CityWorker implements Cloneable
{
    public double progress = 0.0;//from 0 to 1

    public Teacher(Teacher<Type> typeTeacher) {
        super(typeTeacher);
        //two teachers cannot work on same student
	    //in the conext of this cnstructor studdent i most likely nullanyway
	    student = null;
	    progress = 0;
    }

    public Type getStudent() {
        return student;
    }

	public void setStudent(Type student) {
		this.student = student;
	}

	private Type student;

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

    public void doSkill(double time) {
	    if(student != null) {
		    progress += population * time / (AbstractPerson.timeToTrain * student.getPopulation());
		    if (progress > 1.0) {
			    studentCompletedHandler(student);
		    }
	    }
	    paySalary(time);
    }

	private void studentCompletedHandler(Type student) {
		StudentCompletedAlert studentCompletedAlert = new StudentCompletedAlert<Type>(getWorkBuilding().getParentCity(),student, this, location.get(0));
	}

	@Override
    protected CityWorker splitInternal() {
        return new Teacher<>(this);
    }


}