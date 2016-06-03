package engine.people;

import engine.cities.Container;
import engine.people.cityworkers.PeopleInitialConstants;
import engine.tools.AttackableConstants;
import engine.tools.vehicles.Liver;
import engine.tools.vehicles.Weighable;
import engine.tools.weapons.Attackable;
import engine.universe.Country;
import engine.universe.MoneySource;

import java.io.Serializable;

public abstract class AbstractPerson extends Attackable implements Liver, Serializable, Container,Weighable,Cloneable
{
	public MoneySource moneySource;
	public static double healthInitial = 1;
	public static double resistanceInitial = 1;
	public static double timeToTrain = 20;
	private Country country;//final??
	protected int population;
	private double foodUsePerPerson;
	private double crimeRisk;
	private double crimeImpact;
	private double salary;
	protected AbstractPerson(PeopleInitialConstants peopleInitialConstants) {
		super(new AttackableConstants(healthInitial, resistanceInitial, peopleInitialConstants.location));
		registerLiver();
		registerContainer(this);
		moneySource = new MoneySource(0);
		population = peopleInitialConstants.population;
		foodUsePerPerson = peopleInitialConstants.foodUsePerPerson;
		crimeRisk = peopleInitialConstants.crimeRisk;
		crimeImpact = peopleInitialConstants.crimeImpact;
		salary = peopleInitialConstants.salary;
		country = peopleInitialConstants.country;
	}
	protected AbstractPerson(AbstractPerson abstractPerson){
		super(abstractPerson);
		moneySource = abstractPerson.moneySource;
		country = abstractPerson.country;
		population = abstractPerson.population;
		foodUsePerPerson = abstractPerson.foodUsePerPerson;
		crimeRisk = abstractPerson.crimeRisk;
		crimeImpact = abstractPerson.crimeImpact;
		salary  = abstractPerson.salary;
	}
	public double getSalary() {
		return salary;
	}
	public double increaseHealth(double amount) {
		assert (amount <= 1.0 - getHealth());
		return super.increaseHealth(amount);
	}
	public int getPopulation() {
		return population;
	}
	public boolean amIDead() {
		if (population <= 0)
			die();
		if (getHealth() <= 0)
			die();
		return true;
	}
	public abstract void doLife(double time);
	@Override
	public boolean sanityCheck() {
		if(moneySource  == null)
			throw new IllegalStateException();
		if(country == null)
			throw new IllegalStateException();
		return true;
	}
	@Override
	public void die() {
		super.die();
		dieSpecific();
	}
	protected void paySalary(double time) {
		moneySource.pay(moneySource, salary * time);//not a probllem muney sources aren't rwally a think anymore
	}
	protected abstract void dieSpecific();
	@Override
	public double getWeight() {
		return 1;
	}
	@Override
	public int getCount() {
		return population;
	}
	public AbstractPerson split() {
		AbstractPerson clone;
		try {
			clone = (AbstractPerson) this.clone();
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException();
		}
		int totalPop = this.population;
		this.population /= 2;
		clone.setPopulation(totalPop - this.population);
		return clone;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
}