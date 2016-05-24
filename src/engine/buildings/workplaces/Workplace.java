package engine.buildings.workplaces;

//TODO figure out what  the worplace classes actually do.

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
	public ArrayList<CityWorker> getWorkers() {
		return workers;
	}

	public MoneySource getOwner() {
		return owner;
	}

	private ArrayList<CityWorker> workers;
	private int maxWorkers;
	private MoneySource owner;

	public Workplace(AttackableConstants attackableConstants,
	                 CityBlock parentBlock, int maxWorkers, MoneySource owner) {
		super(attackableConstants,parentBlock);
		this.maxWorkers = maxWorkers;
		workers = new ArrayList<>();
		registerContainer(workers);
		this.owner = owner;
	}
	public boolean isEmployee(CityWorker worker) {
		for(CityWorker c:workers)
			if(c == worker)
				return true;
		return false;
	}
	public boolean canAddWorker(CityWorker worker) {
		return worker.getPopulation() + workerCount() < maxWorkers;
	}
	public void addWorker(CityWorker worker) throws IllegalStateException {
		if(canAddWorker(worker))
			workers.add(worker);
		else
			throw new IllegalStateException();
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
	public void remove(AbstractPerson abstractPerson) {
		workers.remove(abstractPerson);
	}
	public void remove(MoneySource moneySource) {
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
}