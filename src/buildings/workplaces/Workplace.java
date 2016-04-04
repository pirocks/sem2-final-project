package buildings.workplaces;

import buildings.Building;
import cities.CityBlock;
import people.AbstractPerson;
import people.cityworkers.CityWorker;
import universe.MoneySource;

import java.util.ArrayList;
public class Workplace extends Building
{
	// MoneySource owner;//for salaries//actually not needed
	public ArrayList<CityWorker> workers;
	public int maxWorkers;
	MoneySource owner;
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