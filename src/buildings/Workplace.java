package buildings;
import cities.*;
public class Workplace extends Building
{
	// MoneySource owner;//for salaries//actually not needed
	public ArrayList<CityWorker> workers;
	public int maxWorkers;
	public Workplace(Type type,ArrayList<CityWorker> workers,CityBlock parentBlock,MoneySource owner)
	{
		super(type,parentBlock,false);
		this.workers = workers;
		this.owner = owner;
	}
	// public void payWorker(CityWorker cityWorker,double amount)
	// {
	// 	assert(isEmployee(cityWorker));
	// 	owner.pay(cityWorker,amount);
	// }//not needed each worker iis payed by the city or government
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
			throw new IllegalStateException()
	}
	public int workerCount()
	{
		int sum = 0;
		for(CityWorker worker:workers)
			sum += worker.getPopulation();
		retur sum;
	}
}