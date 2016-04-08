package engine.tools.vehicles.sea;

/**
 * Created by bob on 4/3/2016.
 *
 */
public abstract class Transporter extends SeaCraft {
	protected Transporter(double resistance, double startHealth, int maxPassengers, double maxWeight) {
		super(resistance, startHealth, maxPassengers, maxWeight);
	}
}
