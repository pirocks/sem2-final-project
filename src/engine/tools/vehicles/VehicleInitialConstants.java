package engine.tools.vehicles;

import engine.tools.ToolInitialConstants;

/**
 * Created by bob on 4/9/2016.
 *
 */
public class VehicleInitialConstants {
	public ToolInitialConstants toolInitialConstants;
	public int maxPassengers;
	public double maxWeight;
	public VehicleInitialConstants(ToolInitialConstants toolInitialConstants,int maxPassengers,double maxWeight){
		this.toolInitialConstants = toolInitialConstants;
		this.maxPassengers = maxPassengers;
		this.maxWeight = maxWeight;
	}
	public VehicleInitialConstants(double health,double resistance,int maxPassengers,double maxWeight){
		this(new ToolInitialConstants(health,resistance),
				maxPassengers,
				maxWeight);
	}
}
