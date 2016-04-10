package engine.tools.vehicles;

import engine.tools.AttackableInitialConstants;

/**
 * Created by bob on 4/9/2016.
 *
 */
public class VehicleInitialConstants {
	public AttackableInitialConstants attackableInitialConstants;
	public int maxPassengers;
	public double maxWeight;
	public VehicleInitialConstants(AttackableInitialConstants attackableInitialConstants, int maxPassengers, double maxWeight){
		this.attackableInitialConstants = attackableInitialConstants;
		this.maxPassengers = maxPassengers;
		this.maxWeight = maxWeight;
	}
	public VehicleInitialConstants(double health,double resistance,int maxPassengers,double maxWeight){
		this(new AttackableInitialConstants(health,resistance),
				maxPassengers,
				maxWeight);
	}
}
