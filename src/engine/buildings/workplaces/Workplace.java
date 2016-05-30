package engine.buildings.workplaces;
import engine.buildings.Building;
import engine.cities.CityBlock;
import engine.cities.Container;
import engine.people.AbstractPerson;
import engine.people.cityworkers.CityWorker;
import engine.tools.AttackableConstants;
import engine.tools.weapons.Attackable;
import engine.universe.MoneySource;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.ArrayList;
public abstract class Workplace extends Building implements Container
{
	private ArrayList<CityWorker> workers;

	private int maxWorkers;
	private MoneySource owner;
	private MoneySource moneySource;

	public Workplace(AttackableConstants attackableConstants,
	                 CityBlock parentBlock, int maxWorkers, MoneySource owner) {
		super(attackableConstants,parentBlock);
		workers = new ArrayList<>();
		this.maxWorkers = maxWorkers;
		if(maxWorkers == 0)
			this.maxWorkers = 1000;
		registerContainer(workers);
		this.owner = owner;
	}
	public boolean isEmployee(CityWorker worker) {
		for(CityWorker c:workers)
			if(c == worker)
				return true;
		return false;
	}
	protected abstract boolean isSuitableType(CityWorker cityWorker);
	public boolean canAddWorker(CityWorker worker) {
		return worker.getPopulation() + workerCount() <= maxWorkers;
	}
	public void addWorker(CityWorker worker) throws ToManyWorkersException, InCorrectWorkerTypeException {
		if(canAddWorker(worker))
			if(isSuitableType(worker)) {
				workers.add(worker);
				worker.registerWorkplace(this);
			}
			else
				throw new InCorrectWorkerTypeException();
		else
			throw new ToManyWorkersException(maxWorkers - workerCount());
	}
	public int workerCount() {
		int sum = 0;
		for(CityWorker worker:workers)
			sum += worker.getPopulation();
		return sum;
	}
	public void leavePerson(AbstractPerson person) {
		assert(workers.contains(person));
		workers.remove(person);
	}
	private void remove(AbstractPerson abstractPerson) {
		workers.remove(abstractPerson);
	}
	private void remove(MoneySource moneySource) {
		if(owner == moneySource)
		{
			owner = null;
		}
	}
	public int getMaxWorkers() {
		return maxWorkers;
	}
	@Override
	public VBox getPane() {
		VBox out = new VBox();
		out.getChildren().add(new Text(name));
		out.getChildren().add(new Text("Currently Employs:" + workerCount()));
		out.getChildren().add(new Text("Worker Limit:" + getMaxWorkers()));
		addSpecific(out);
		return out;
	}
	public abstract void addSpecific(VBox in);
	@Override
	public void remove(Attackable attackable) {
		super.remove(attackable);
		if(attackable instanceof AbstractPerson){
			remove((AbstractPerson)attackable);
		}
	}
	public ArrayList<CityWorker> getWorkers() {
		return workers;
	}
	public MoneySource getOwner() {
		return owner;
	}
	public abstract CityWorker createCorrectType();
	public MoneySource getMoneySource() {
		return moneySource;
	}

	@Override
	public void die() {
		super.die();
		for (CityWorker worker : workers) {
			if(worker.getCurrentBuilding() == this)
				if(!worker.amIDead)
					worker.die();
		}

	}
}