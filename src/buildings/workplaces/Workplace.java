package buildings.workplaces;

import buildings.Building;
import cities.CityBlock;
import people.AbstractPerson;
import people.PersonContainer;
import people.cityworkers.CityWorker;
import universe.MoneySource;
import universe.MoneySourceContainer;

import java.util.ArrayList;
public abstract class Workplace extends Building  implements PersonContainer, MoneySourceContainer
{
	// MoneySource owner;//for salaries//actually not needed
	private ArrayList<CityWorker> workers;
	private int maxWorkers;
	private MoneySource owner;
	public Workplace(Type type,ArrayList<CityWorker> workers,CityBlock parentBlock,MoneySource owner)
	{
		super(type,parentBlock,false);
		this.workers = workers;
		this.owner = owner;
	}
	public boolean isEmployee(CityWorker worker)
	{
		for(CityWorker c:workers)
			if(c == worker)
				return true;
		return false;
	}
	public boolean canAddWorker(CityWorker worker)
	{
		return worker.getPopulation() + workerCount() < maxWorkers;
	}
	public void addWorker(CityWorker worker) throws IllegalStateException
	{
		if(canAddWorker(worker))
			workers.add(worker);
		else
			throw new IllegalStateException();
	}
	public int workerCount()
	{
		int sum = 0;
		for(CityWorker worker:workers)
			sum += worker.getPopulation();
		return sum;
	}
	public void leavePerson(AbstractPerson person)
	{
		assert(workers.contains(person));
		workers.remove(person);
	}
}