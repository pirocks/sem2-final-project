package engine.buildings.workplaces;

/**
 * Created by bob on 5/26/2016.
 */
public class ToManyWorkersException extends Exception{
	private int workersRemaining;

	ToManyWorkersException(int workersRemaining) {
		super();
		this.workersRemaining = workersRemaining;
	}

	public int getWorkersRemaining() {
		return workersRemaining;
	}
}
