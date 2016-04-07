package tools.vehicles.roadgoing;

/**
 * Created by bob on 4/3/2016.
 */
public abstract class Truck extends RoadGoing {
	protected Truck(double resistance, double startHealth, int maxPassengers, double maxWeight) {
		super(resistance, startHealth, maxPassengers, maxWeight);
	}
}
